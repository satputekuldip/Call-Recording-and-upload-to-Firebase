package com.spark.mistore.data;

import android.content.Context;
import com.spark.mistore.data.db.DbHelper;
import com.spark.mistore.data.network.ApiHelper;
import com.spark.mistore.data.prefs.PreferencesHelper;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppDataManager_Factory implements Factory<AppDataManager> {
  private final Provider<Context> contextProvider;

  private final Provider<DbHelper> dbHelperProvider;

  private final Provider<PreferencesHelper> preferencesHelperProvider;

  private final Provider<ApiHelper> apiHelperProvider;

  public AppDataManager_Factory(
      Provider<Context> contextProvider,
      Provider<DbHelper> dbHelperProvider,
      Provider<PreferencesHelper> preferencesHelperProvider,
      Provider<ApiHelper> apiHelperProvider) {
    this.contextProvider = contextProvider;
    this.dbHelperProvider = dbHelperProvider;
    this.preferencesHelperProvider = preferencesHelperProvider;
    this.apiHelperProvider = apiHelperProvider;
  }

  @Override
  public AppDataManager get() {
    return provideInstance(
        contextProvider, dbHelperProvider, preferencesHelperProvider, apiHelperProvider);
  }

  public static AppDataManager provideInstance(
      Provider<Context> contextProvider,
      Provider<DbHelper> dbHelperProvider,
      Provider<PreferencesHelper> preferencesHelperProvider,
      Provider<ApiHelper> apiHelperProvider) {
    return new AppDataManager(
        contextProvider.get(),
        dbHelperProvider.get(),
        preferencesHelperProvider.get(),
        apiHelperProvider.get());
  }

  public static AppDataManager_Factory create(
      Provider<Context> contextProvider,
      Provider<DbHelper> dbHelperProvider,
      Provider<PreferencesHelper> preferencesHelperProvider,
      Provider<ApiHelper> apiHelperProvider) {
    return new AppDataManager_Factory(
        contextProvider, dbHelperProvider, preferencesHelperProvider, apiHelperProvider);
  }

  public static AppDataManager newAppDataManager(
      Context context,
      DbHelper dbHelper,
      PreferencesHelper preferencesHelper,
      ApiHelper apiHelper) {
    return new AppDataManager(context, dbHelper, preferencesHelper, apiHelper);
  }
}
