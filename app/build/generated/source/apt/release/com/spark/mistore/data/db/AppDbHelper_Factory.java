package com.spark.mistore.data.db;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppDbHelper_Factory implements Factory<AppDbHelper> {
  private final Provider<DbOpenHelper> dbOpenHelperProvider;

  public AppDbHelper_Factory(Provider<DbOpenHelper> dbOpenHelperProvider) {
    this.dbOpenHelperProvider = dbOpenHelperProvider;
  }

  @Override
  public AppDbHelper get() {
    return provideInstance(dbOpenHelperProvider);
  }

  public static AppDbHelper provideInstance(Provider<DbOpenHelper> dbOpenHelperProvider) {
    return new AppDbHelper(dbOpenHelperProvider.get());
  }

  public static AppDbHelper_Factory create(Provider<DbOpenHelper> dbOpenHelperProvider) {
    return new AppDbHelper_Factory(dbOpenHelperProvider);
  }

  public static AppDbHelper newAppDbHelper(DbOpenHelper dbOpenHelper) {
    return new AppDbHelper(dbOpenHelper);
  }
}
