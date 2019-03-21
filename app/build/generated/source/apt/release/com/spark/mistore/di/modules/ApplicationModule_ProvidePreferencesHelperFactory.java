package com.spark.mistore.di.modules;

import com.spark.mistore.data.prefs.AppPreferencesHelper;
import com.spark.mistore.data.prefs.PreferencesHelper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvidePreferencesHelperFactory
    implements Factory<PreferencesHelper> {
  private final ApplicationModule module;

  private final Provider<AppPreferencesHelper> appPreferencesHelperProvider;

  public ApplicationModule_ProvidePreferencesHelperFactory(
      ApplicationModule module, Provider<AppPreferencesHelper> appPreferencesHelperProvider) {
    this.module = module;
    this.appPreferencesHelperProvider = appPreferencesHelperProvider;
  }

  @Override
  public PreferencesHelper get() {
    return provideInstance(module, appPreferencesHelperProvider);
  }

  public static PreferencesHelper provideInstance(
      ApplicationModule module, Provider<AppPreferencesHelper> appPreferencesHelperProvider) {
    return proxyProvidePreferencesHelper(module, appPreferencesHelperProvider.get());
  }

  public static ApplicationModule_ProvidePreferencesHelperFactory create(
      ApplicationModule module, Provider<AppPreferencesHelper> appPreferencesHelperProvider) {
    return new ApplicationModule_ProvidePreferencesHelperFactory(
        module, appPreferencesHelperProvider);
  }

  public static PreferencesHelper proxyProvidePreferencesHelper(
      ApplicationModule instance, AppPreferencesHelper appPreferencesHelper) {
    return Preconditions.checkNotNull(
        instance.providePreferencesHelper(appPreferencesHelper),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
