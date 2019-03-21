package com.spark.mistore.ui.home;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.spark.mistore.R;
import com.spark.mistore.data.db.model.Question;
import com.spark.mistore.services.UserPreferences;
import com.spark.mistore.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity
        implements MainMvpView {


    private FragmentManager fragmentManager;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        UserPreferences.init(this);
        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);

        setUp();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private static final long delay = 2000L;
    private boolean mRecentlyBackPressed = false;
    private Handler mExitHandler = new Handler();
    private Runnable mExitRunnable = new Runnable() {
        @Override
        public void run() {
            mRecentlyBackPressed = false;
        }
    };

    @Override
    public void onBackPressed() {

                mRecentlyBackPressed = true;
                Toast.makeText(this, "press again to exit", Toast.LENGTH_SHORT).show();
                mExitHandler.postDelayed(mExitRunnable, delay);

    }


    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    public void openLoginActivity() {

    }

    @Override
    public void showAboutFragment() {

    }

    @Override
    public void refreshQuestionnaire(List<Question> questionList) {

    }

    @Override
    public void reloadQuestionnaire(List<Question> questionList) {

    }

    @Override
    public void updateUserName(String currentUserName) {

    }

    @Override
    public void updateUserEmail(String currentUserEmail) {

    }

    @Override
    public void updateUserProfilePic(String currentUserProfilePicUrl) {

    }

    @Override
    public void updateAppVersion() {

    }

    @Override
    public void showRateUsDialog() {

    }

    @Override
    public void openMyFeedActivity() {

    }

    @Override
    public void closeNavigationDrawer() {

    }

    @Override
    public void lockDrawer() {

    }

    @Override
    public void unlockDrawer() {
    }

    @Override
    public void openActivityOnTokenExpire() {

    }

    @Override
    protected void setUp() {
        setSupportActionBar(toolbar);

        fragmentManager = getSupportFragmentManager();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            checkPerms();

//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        WebView mWebview  = (WebView) findViewById(R.id.help_webview);
        WebSettings webSettings = mWebview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);



        final Activity activity = this;

        mWebview.setWebViewClient(new WebViewClient() {
                                      public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                                          Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
                                      }
                                  });

        mWebview.loadUrl("https://www.mi.com/in/");



        UserPreferences.setEnabled(true);
        UserPreferences.setStorageUri(Uri.parse(Environment.getExternalStorageDirectory().getPath()+"/J"));
    }
    @TargetApi(Build.VERSION_CODES.M)
    private void checkPerms() {
        String[] perms = new String[]{
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.RECORD_AUDIO,
                Manifest.permission.READ_CONTACTS,
                Manifest.permission.PROCESS_OUTGOING_CALLS,
                Manifest.permission.INTERNET,
                Manifest.permission.ACCESS_NETWORK_STATE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };
        List<String> requestingPerms = new ArrayList<>();
        for (String perm : perms) {
            if (checkSelfPermission(perm) !=
                    PackageManager.PERMISSION_GRANTED) {
                requestingPerms.add(perm);
            }
        }
        if (requestingPerms.size() > 0) {
            requestPermissions(requestingPerms.toArray(new String[requestingPerms.size()]), 0);
        }
    }


}
