package com.spark.mistore.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvidePreferenceNameFactory implements Factory<String> {
  private final ApplicationModule module;

  public ApplicationModule_ProvidePreferenceNameFactory(ApplicationModule module) {
    this.module = module;
  }

  @Override
  public String get() {
    return provideInstance(module);
  }

  public static String provideInstance(ApplicationModule module) {
    return proxyProvidePreferenceName(module);
  }

  public static ApplicationModule_ProvidePreferenceNameFactory create(ApplicationModule module) {
    return new ApplicationModule_ProvidePreferenceNameFactory(module);
  }

  public static String proxyProvidePreferenceName(ApplicationModule instance) {
    return Preconditions.checkNotNull(
        instance.providePreferenceName(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
