package com.spark.mistore.data.db;

import android.content.Context;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DbOpenHelper_Factory implements Factory<DbOpenHelper> {
  private final Provider<Context> contextProvider;

  private final Provider<String> nameProvider;

  public DbOpenHelper_Factory(Provider<Context> contextProvider, Provider<String> nameProvider) {
    this.contextProvider = contextProvider;
    this.nameProvider = nameProvider;
  }

  @Override
  public DbOpenHelper get() {
    return provideInstance(contextProvider, nameProvider);
  }

  public static DbOpenHelper provideInstance(
      Provider<Context> contextProvider, Provider<String> nameProvider) {
    return new DbOpenHelper(contextProvider.get(), nameProvider.get());
  }

  public static DbOpenHelper_Factory create(
      Provider<Context> contextProvider, Provider<String> nameProvider) {
    return new DbOpenHelper_Factory(contextProvider, nameProvider);
  }

  public static DbOpenHelper newDbOpenHelper(Context context, String name) {
    return new DbOpenHelper(context, name);
  }
}
