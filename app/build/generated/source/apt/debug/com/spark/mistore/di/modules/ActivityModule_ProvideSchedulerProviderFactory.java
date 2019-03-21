package com.spark.mistore.di.modules;

import com.spark.mistore.utils.rx.SchedulerProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ActivityModule_ProvideSchedulerProviderFactory
    implements Factory<SchedulerProvider> {
  private final ActivityModule module;

  public ActivityModule_ProvideSchedulerProviderFactory(ActivityModule module) {
    this.module = module;
  }

  @Override
  public SchedulerProvider get() {
    return provideInstance(module);
  }

  public static SchedulerProvider provideInstance(ActivityModule module) {
    return proxyProvideSchedulerProvider(module);
  }

  public static ActivityModule_ProvideSchedulerProviderFactory create(ActivityModule module) {
    return new ActivityModule_ProvideSchedulerProviderFactory(module);
  }

  public static SchedulerProvider proxyProvideSchedulerProvider(ActivityModule instance) {
    return Preconditions.checkNotNull(
        instance.provideSchedulerProvider(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
