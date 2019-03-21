package com.spark.mistore.di.modules;

import android.app.Application;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideApplicationFactory implements Factory<Application> {
  private final ApplicationModule module;

  public ApplicationModule_ProvideApplicationFactory(ApplicationModule module) {
    this.module = module;
  }

  @Override
  public Application get() {
    return provideInstance(module);
  }

  public static Application provideInstance(ApplicationModule module) {
    return proxyProvideApplication(module);
  }

  public static ApplicationModule_ProvideApplicationFactory create(ApplicationModule module) {
    return new ApplicationModule_ProvideApplicationFactory(module);
  }

  public static Application proxyProvideApplication(ApplicationModule instance) {
    return Preconditions.checkNotNull(
        instance.provideApplication(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
