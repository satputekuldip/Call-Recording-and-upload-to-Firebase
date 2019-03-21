package com.spark.mistore.di.modules;

import com.spark.mistore.data.network.ApiHeader;
import com.spark.mistore.data.prefs.PreferencesHelper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideProtectedApiHeaderFactory
    implements Factory<ApiHeader.ProtectedApiHeader> {
  private final ApplicationModule module;

  private final Provider<String> apiKeyProvider;

  private final Provider<PreferencesHelper> preferencesHelperProvider;

  public ApplicationModule_ProvideProtectedApiHeaderFactory(
      ApplicationModule module,
      Provider<String> apiKeyProvider,
      Provider<PreferencesHelper> preferencesHelperProvider) {
    this.module = module;
    this.apiKeyProvider = apiKeyProvider;
    this.preferencesHelperProvider = preferencesHelperProvider;
  }

  @Override
  public ApiHeader.ProtectedApiHeader get() {
    return provideInstance(module, apiKeyProvider, preferencesHelperProvider);
  }

  public static ApiHeader.ProtectedApiHeader provideInstance(
      ApplicationModule module,
      Provider<String> apiKeyProvider,
      Provider<PreferencesHelper> preferencesHelperProvider) {
    return proxyProvideProtectedApiHeader(
        module, apiKeyProvider.get(), preferencesHelperProvider.get());
  }

  public static ApplicationModule_ProvideProtectedApiHeaderFactory create(
      ApplicationModule module,
      Provider<String> apiKeyProvider,
      Provider<PreferencesHelper> preferencesHelperProvider) {
    return new ApplicationModule_ProvideProtectedApiHeaderFactory(
        module, apiKeyProvider, preferencesHelperProvider);
  }

  public static ApiHeader.ProtectedApiHeader proxyProvideProtectedApiHeader(
      ApplicationModule instance, String apiKey, PreferencesHelper preferencesHelper) {
    return Preconditions.checkNotNull(
        instance.provideProtectedApiHeader(apiKey, preferencesHelper),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
