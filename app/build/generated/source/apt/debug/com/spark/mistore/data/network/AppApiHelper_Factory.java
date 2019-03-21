package com.spark.mistore.data.network;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppApiHelper_Factory implements Factory<AppApiHelper> {
  private final Provider<ApiHeader> apiHeaderProvider;

  public AppApiHelper_Factory(Provider<ApiHeader> apiHeaderProvider) {
    this.apiHeaderProvider = apiHeaderProvider;
  }

  @Override
  public AppApiHelper get() {
    return provideInstance(apiHeaderProvider);
  }

  public static AppApiHelper provideInstance(Provider<ApiHeader> apiHeaderProvider) {
    return new AppApiHelper(apiHeaderProvider.get());
  }

  public static AppApiHelper_Factory create(Provider<ApiHeader> apiHeaderProvider) {
    return new AppApiHelper_Factory(apiHeaderProvider);
  }

  public static AppApiHelper newAppApiHelper(ApiHeader apiHeader) {
    return new AppApiHelper(apiHeader);
  }
}
