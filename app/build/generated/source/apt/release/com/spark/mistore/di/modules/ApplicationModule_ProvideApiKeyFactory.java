package com.spark.mistore.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideApiKeyFactory implements Factory<String> {
  private final ApplicationModule module;

  public ApplicationModule_ProvideApiKeyFactory(ApplicationModule module) {
    this.module = module;
  }

  @Override
  public String get() {
    return provideInstance(module);
  }

  public static String provideInstance(ApplicationModule module) {
    return proxyProvideApiKey(module);
  }

  public static ApplicationModule_ProvideApiKeyFactory create(ApplicationModule module) {
    return new ApplicationModule_ProvideApiKeyFactory(module);
  }

  public static String proxyProvideApiKey(ApplicationModule instance) {
    return Preconditions.checkNotNull(
        instance.provideApiKey(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
