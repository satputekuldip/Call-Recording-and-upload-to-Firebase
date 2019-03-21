package com.spark.mistore.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.reactivex.disposables.CompositeDisposable;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ActivityModule_ProvideCompositeDisposableFactory
    implements Factory<CompositeDisposable> {
  private final ActivityModule module;

  public ActivityModule_ProvideCompositeDisposableFactory(ActivityModule module) {
    this.module = module;
  }

  @Override
  public CompositeDisposable get() {
    return provideInstance(module);
  }

  public static CompositeDisposable provideInstance(ActivityModule module) {
    return proxyProvideCompositeDisposable(module);
  }

  public static ActivityModule_ProvideCompositeDisposableFactory create(ActivityModule module) {
    return new ActivityModule_ProvideCompositeDisposableFactory(module);
  }

  public static CompositeDisposable proxyProvideCompositeDisposable(ActivityModule instance) {
    return Preconditions.checkNotNull(
        instance.provideCompositeDisposable(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
