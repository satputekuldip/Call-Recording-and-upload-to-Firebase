package com.spark.mistore.ui.home;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<MainMvpPresenter<MainMvpView>> mPresenterProvider;

  public MainActivity_MembersInjector(Provider<MainMvpPresenter<MainMvpView>> mPresenterProvider) {
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<MainActivity> create(
      Provider<MainMvpPresenter<MainMvpView>> mPresenterProvider) {
    return new MainActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    injectMPresenter(instance, mPresenterProvider.get());
  }

  public static void injectMPresenter(
      MainActivity instance, MainMvpPresenter<MainMvpView> mPresenter) {
    instance.mPresenter = mPresenter;
  }
}
