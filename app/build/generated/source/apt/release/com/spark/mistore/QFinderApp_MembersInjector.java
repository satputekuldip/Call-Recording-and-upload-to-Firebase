package com.spark.mistore;

import com.spark.mistore.data.DataManager;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class QFinderApp_MembersInjector implements MembersInjector<QFinderApp> {
  private final Provider<DataManager> mDataManagerProvider;

  private final Provider<CalligraphyConfig> mCalligraphyConfigProvider;

  public QFinderApp_MembersInjector(
      Provider<DataManager> mDataManagerProvider,
      Provider<CalligraphyConfig> mCalligraphyConfigProvider) {
    this.mDataManagerProvider = mDataManagerProvider;
    this.mCalligraphyConfigProvider = mCalligraphyConfigProvider;
  }

  public static MembersInjector<QFinderApp> create(
      Provider<DataManager> mDataManagerProvider,
      Provider<CalligraphyConfig> mCalligraphyConfigProvider) {
    return new QFinderApp_MembersInjector(mDataManagerProvider, mCalligraphyConfigProvider);
  }

  @Override
  public void injectMembers(QFinderApp instance) {
    injectMDataManager(instance, mDataManagerProvider.get());
    injectMCalligraphyConfig(instance, mCalligraphyConfigProvider.get());
  }

  public static void injectMDataManager(QFinderApp instance, DataManager mDataManager) {
    instance.mDataManager = mDataManager;
  }

  public static void injectMCalligraphyConfig(
      QFinderApp instance, CalligraphyConfig mCalligraphyConfig) {
    instance.mCalligraphyConfig = mCalligraphyConfig;
  }
}
