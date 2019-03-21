package com.spark.mistore.di.modules;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ActivityModule_ProvideLinearLayoutManagerFactory
    implements Factory<LinearLayoutManager> {
  private final ActivityModule module;

  private final Provider<AppCompatActivity> activityProvider;

  public ActivityModule_ProvideLinearLayoutManagerFactory(
      ActivityModule module, Provider<AppCompatActivity> activityProvider) {
    this.module = module;
    this.activityProvider = activityProvider;
  }

  @Override
  public LinearLayoutManager get() {
    return provideInstance(module, activityProvider);
  }

  public static LinearLayoutManager provideInstance(
      ActivityModule module, Provider<AppCompatActivity> activityProvider) {
    return proxyProvideLinearLayoutManager(module, activityProvider.get());
  }

  public static ActivityModule_ProvideLinearLayoutManagerFactory create(
      ActivityModule module, Provider<AppCompatActivity> activityProvider) {
    return new ActivityModule_ProvideLinearLayoutManagerFactory(module, activityProvider);
  }

  public static LinearLayoutManager proxyProvideLinearLayoutManager(
      ActivityModule instance, AppCompatActivity activity) {
    return Preconditions.checkNotNull(
        instance.provideLinearLayoutManager(activity),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
