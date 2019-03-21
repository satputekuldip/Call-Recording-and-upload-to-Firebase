package com.spark.mistore.ui.home;

import com.spark.mistore.data.DataManager;
import com.spark.mistore.utils.rx.SchedulerProvider;
import dagger.internal.Factory;
import io.reactivex.disposables.CompositeDisposable;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MainPresenter_Factory<V extends MainMvpView>
    implements Factory<MainPresenter<V>> {
  private final Provider<DataManager> dataManagerProvider;

  private final Provider<SchedulerProvider> schedulerProvider;

  private final Provider<CompositeDisposable> compositeDisposableProvider;

  public MainPresenter_Factory(
      Provider<DataManager> dataManagerProvider,
      Provider<SchedulerProvider> schedulerProvider,
      Provider<CompositeDisposable> compositeDisposableProvider) {
    this.dataManagerProvider = dataManagerProvider;
    this.schedulerProvider = schedulerProvider;
    this.compositeDisposableProvider = compositeDisposableProvider;
  }

  @Override
  public MainPresenter<V> get() {
    return provideInstance(dataManagerProvider, schedulerProvider, compositeDisposableProvider);
  }

  public static <V extends MainMvpView> MainPresenter<V> provideInstance(
      Provider<DataManager> dataManagerProvider,
      Provider<SchedulerProvider> schedulerProvider,
      Provider<CompositeDisposable> compositeDisposableProvider) {
    return new MainPresenter<V>(
        dataManagerProvider.get(), schedulerProvider.get(), compositeDisposableProvider.get());
  }

  public static <V extends MainMvpView> MainPresenter_Factory<V> create(
      Provider<DataManager> dataManagerProvider,
      Provider<SchedulerProvider> schedulerProvider,
      Provider<CompositeDisposable> compositeDisposableProvider) {
    return new MainPresenter_Factory<V>(
        dataManagerProvider, schedulerProvider, compositeDisposableProvider);
  }

  public static <V extends MainMvpView> MainPresenter<V> newMainPresenter(
      DataManager dataManager,
      SchedulerProvider schedulerProvider,
      CompositeDisposable compositeDisposable) {
    return new MainPresenter<V>(dataManager, schedulerProvider, compositeDisposable);
  }
}
