package com.spark.mistore.ui.base;

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
public final class BasePresenter_Factory<V extends MvpView> implements Factory<BasePresenter<V>> {
  private final Provider<DataManager> dataManagerProvider;

  private final Provider<SchedulerProvider> schedulerProvider;

  private final Provider<CompositeDisposable> compositeDisposableProvider;

  public BasePresenter_Factory(
      Provider<DataManager> dataManagerProvider,
      Provider<SchedulerProvider> schedulerProvider,
      Provider<CompositeDisposable> compositeDisposableProvider) {
    this.dataManagerProvider = dataManagerProvider;
    this.schedulerProvider = schedulerProvider;
    this.compositeDisposableProvider = compositeDisposableProvider;
  }

  @Override
  public BasePresenter<V> get() {
    return provideInstance(dataManagerProvider, schedulerProvider, compositeDisposableProvider);
  }

  public static <V extends MvpView> BasePresenter<V> provideInstance(
      Provider<DataManager> dataManagerProvider,
      Provider<SchedulerProvider> schedulerProvider,
      Provider<CompositeDisposable> compositeDisposableProvider) {
    return new BasePresenter<V>(
        dataManagerProvider.get(), schedulerProvider.get(), compositeDisposableProvider.get());
  }

  public static <V extends MvpView> BasePresenter_Factory<V> create(
      Provider<DataManager> dataManagerProvider,
      Provider<SchedulerProvider> schedulerProvider,
      Provider<CompositeDisposable> compositeDisposableProvider) {
    return new BasePresenter_Factory<V>(
        dataManagerProvider, schedulerProvider, compositeDisposableProvider);
  }

  public static <V extends MvpView> BasePresenter<V> newBasePresenter(
      DataManager dataManager,
      SchedulerProvider schedulerProvider,
      CompositeDisposable compositeDisposable) {
    return new BasePresenter<V>(dataManager, schedulerProvider, compositeDisposable);
  }
}
