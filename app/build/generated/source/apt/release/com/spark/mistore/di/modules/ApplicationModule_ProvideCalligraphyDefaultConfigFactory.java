package com.spark.mistore.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideCalligraphyDefaultConfigFactory
    implements Factory<CalligraphyConfig> {
  private final ApplicationModule module;

  public ApplicationModule_ProvideCalligraphyDefaultConfigFactory(ApplicationModule module) {
    this.module = module;
  }

  @Override
  public CalligraphyConfig get() {
    return provideInstance(module);
  }

  public static CalligraphyConfig provideInstance(ApplicationModule module) {
    return proxyProvideCalligraphyDefaultConfig(module);
  }

  public static ApplicationModule_ProvideCalligraphyDefaultConfigFactory create(
      ApplicationModule module) {
    return new ApplicationModule_ProvideCalligraphyDefaultConfigFactory(module);
  }

  public static CalligraphyConfig proxyProvideCalligraphyDefaultConfig(ApplicationModule instance) {
    return Preconditions.checkNotNull(
        instance.provideCalligraphyDefaultConfig(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
