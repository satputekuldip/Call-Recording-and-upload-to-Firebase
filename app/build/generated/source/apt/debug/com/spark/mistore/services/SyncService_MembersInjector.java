package com.spark.mistore.services;

import com.spark.mistore.data.DataManager;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SyncService_MembersInjector implements MembersInjector<SyncService> {
  private final Provider<DataManager> mDataManagerProvider;

  public SyncService_MembersInjector(Provider<DataManager> mDataManagerProvider) {
    this.mDataManagerProvider = mDataManagerProvider;
  }

  public static MembersInjector<SyncService> create(Provider<DataManager> mDataManagerProvider) {
    return new SyncService_MembersInjector(mDataManagerProvider);
  }

  @Override
  public void injectMembers(SyncService instance) {
    injectMDataManager(instance, mDataManagerProvider.get());
  }

  public static void injectMDataManager(SyncService instance, DataManager mDataManager) {
    instance.mDataManager = mDataManager;
  }
}
