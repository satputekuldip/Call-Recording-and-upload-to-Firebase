package com.spark.mistore.di.modules;

import com.spark.mistore.data.network.ApiHelper;
import com.spark.mistore.data.network.AppApiHelper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideApiHelperFactory implements Factory<ApiHelper> {
  private final ApplicationModule module;

  private final Provider<AppApiHelper> appApiHelperProvider;

  public ApplicationModule_ProvideApiHelperFactory(
      ApplicationModule module, Provider<AppApiHelper> appApiHelperProvider) {
    this.module = module;
    this.appApiHelperProvider = appApiHelperProvider;
  }

  @Override
  public ApiHelper get() {
    return provideInstance(module, appApiHelperProvider);
  }

  public static ApiHelper provideInstance(
      ApplicationModule module, Provider<AppApiHelper> appApiHelperProvider) {
    return proxyProvideApiHelper(module, appApiHelperProvider.get());
  }

  public static ApplicationModule_ProvideApiHelperFactory create(
      ApplicationModule module, Provider<AppApiHelper> appApiHelperProvider) {
    return new ApplicationModule_ProvideApiHelperFactory(module, appApiHelperProvider);
  }

  public static ApiHelper proxyProvideApiHelper(
      ApplicationModule instance, AppApiHelper appApiHelper) {
    return Preconditions.checkNotNull(
        instance.provideApiHelper(appApiHelper),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
