package com.spark.mistore.data.prefs;

import android.content.Context;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppPreferencesHelper_Factory implements Factory<AppPreferencesHelper> {
  private final Provider<Context> contextProvider;

  private final Provider<String> prefFileNameProvider;

  public AppPreferencesHelper_Factory(
      Provider<Context> contextProvider, Provider<String> prefFileNameProvider) {
    this.contextProvider = contextProvider;
    this.prefFileNameProvider = prefFileNameProvider;
  }

  @Override
  public AppPreferencesHelper get() {
    return provideInstance(contextProvider, prefFileNameProvider);
  }

  public static AppPreferencesHelper provideInstance(
      Provider<Context> contextProvider, Provider<String> prefFileNameProvider) {
    return new AppPreferencesHelper(contextProvider.get(), prefFileNameProvider.get());
  }

  public static AppPreferencesHelper_Factory create(
      Provider<Context> contextProvider, Provider<String> prefFileNameProvider) {
    return new AppPreferencesHelper_Factory(contextProvider, prefFileNameProvider);
  }

  public static AppPreferencesHelper newAppPreferencesHelper(Context context, String prefFileName) {
    return new AppPreferencesHelper(context, prefFileName);
  }
}
