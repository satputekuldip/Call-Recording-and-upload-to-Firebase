package com.spark.mistore.di.modules;

import com.spark.mistore.ui.home.MainMvpPresenter;
import com.spark.mistore.ui.home.MainMvpView;
import com.spark.mistore.ui.home.MainPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ActivityModule_ProvideMainPresenterFactory
    implements Factory<MainMvpPresenter<MainMvpView>> {
  private final ActivityModule module;

  private final Provider<MainPresenter<MainMvpView>> presenterProvider;

  public ActivityModule_ProvideMainPresenterFactory(
      ActivityModule module, Provider<MainPresenter<MainMvpView>> presenterProvider) {
    this.module = module;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public MainMvpPresenter<MainMvpView> get() {
    return provideInstance(module, presenterProvider);
  }

  public static MainMvpPresenter<MainMvpView> provideInstance(
      ActivityModule module, Provider<MainPresenter<MainMvpView>> presenterProvider) {
    return proxyProvideMainPresenter(module, presenterProvider.get());
  }

  public static ActivityModule_ProvideMainPresenterFactory create(
      ActivityModule module, Provider<MainPresenter<MainMvpView>> presenterProvider) {
    return new ActivityModule_ProvideMainPresenterFactory(module, presenterProvider);
  }

  public static MainMvpPresenter<MainMvpView> proxyProvideMainPresenter(
      ActivityModule instance, MainPresenter<MainMvpView> presenter) {
    return Preconditions.checkNotNull(
        instance.provideMainPresenter(presenter),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
