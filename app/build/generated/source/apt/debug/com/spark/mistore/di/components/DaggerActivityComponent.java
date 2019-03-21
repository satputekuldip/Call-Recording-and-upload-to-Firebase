package com.spark.mistore.di.components;

import com.spark.mistore.data.DataManager;
import com.spark.mistore.di.modules.ActivityModule;
import com.spark.mistore.di.modules.ActivityModule_ProvideCompositeDisposableFactory;
import com.spark.mistore.di.modules.ActivityModule_ProvideMainPresenterFactory;
import com.spark.mistore.di.modules.ActivityModule_ProvideSchedulerProviderFactory;
import com.spark.mistore.ui.home.MainActivity;
import com.spark.mistore.ui.home.MainActivity_MembersInjector;
import com.spark.mistore.ui.home.MainMvpPresenter;
import com.spark.mistore.ui.home.MainMvpView;
import com.spark.mistore.ui.home.MainPresenter_Factory;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerActivityComponent implements ActivityComponent {
  private com_spark_mistore_di_components_ApplicationComponent_getDataManager
      getDataManagerProvider;

  private ActivityModule_ProvideSchedulerProviderFactory provideSchedulerProvider;

  private ActivityModule_ProvideCompositeDisposableFactory provideCompositeDisposableProvider;

  private MainPresenter_Factory mainPresenterProvider;

  private Provider<MainMvpPresenter<MainMvpView>> provideMainPresenterProvider;

  private DaggerActivityComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.getDataManagerProvider =
        new com_spark_mistore_di_components_ApplicationComponent_getDataManager(
            builder.applicationComponent);
    this.provideSchedulerProvider =
        ActivityModule_ProvideSchedulerProviderFactory.create(builder.activityModule);
    this.provideCompositeDisposableProvider =
        ActivityModule_ProvideCompositeDisposableFactory.create(builder.activityModule);
    this.mainPresenterProvider =
        MainPresenter_Factory.create(
            getDataManagerProvider, provideSchedulerProvider, provideCompositeDisposableProvider);
    this.provideMainPresenterProvider =
        DoubleCheck.provider(
            ActivityModule_ProvideMainPresenterFactory.create(
                builder.activityModule, mainPresenterProvider));
  }

  @Override
  public void inject(MainActivity activity) {
    injectMainActivity(activity);
  }

  private MainActivity injectMainActivity(MainActivity instance) {
    MainActivity_MembersInjector.injectMPresenter(instance, provideMainPresenterProvider.get());
    return instance;
  }

  public static final class Builder {
    private ActivityModule activityModule;

    private ApplicationComponent applicationComponent;

    private Builder() {}

    public ActivityComponent build() {
      if (activityModule == null) {
        throw new IllegalStateException(ActivityModule.class.getCanonicalName() + " must be set");
      }
      if (applicationComponent == null) {
        throw new IllegalStateException(
            ApplicationComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerActivityComponent(this);
    }

    public Builder activityModule(ActivityModule activityModule) {
      this.activityModule = Preconditions.checkNotNull(activityModule);
      return this;
    }

    public Builder applicationComponent(ApplicationComponent applicationComponent) {
      this.applicationComponent = Preconditions.checkNotNull(applicationComponent);
      return this;
    }
  }

  private static class com_spark_mistore_di_components_ApplicationComponent_getDataManager
      implements Provider<DataManager> {
    private final ApplicationComponent applicationComponent;

    com_spark_mistore_di_components_ApplicationComponent_getDataManager(
        ApplicationComponent applicationComponent) {
      this.applicationComponent = applicationComponent;
    }

    @Override
    public DataManager get() {
      return Preconditions.checkNotNull(
          applicationComponent.getDataManager(),
          "Cannot return null from a non-@Nullable component method");
    }
  }
}
