package com.spark.mistore.di.components;

import com.spark.mistore.di.modules.ServiceModule;
import com.spark.mistore.services.SyncService;
import com.spark.mistore.services.SyncService_MembersInjector;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerServiceComponent implements ServiceComponent {
  private ApplicationComponent applicationComponent;

  private DaggerServiceComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.applicationComponent = builder.applicationComponent;
  }

  @Override
  public void inject(SyncService service) {
    injectSyncService(service);
  }

  private SyncService injectSyncService(SyncService instance) {
    SyncService_MembersInjector.injectMDataManager(
        instance,
        Preconditions.checkNotNull(
            applicationComponent.getDataManager(),
            "Cannot return null from a non-@Nullable component method"));
    return instance;
  }

  public static final class Builder {
    private ApplicationComponent applicationComponent;

    private Builder() {}

    public ServiceComponent build() {
      if (applicationComponent == null) {
        throw new IllegalStateException(
            ApplicationComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerServiceComponent(this);
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This
     *     method is a no-op. For more, see https://google.github.io/dagger/unused-modules.
     */
    @Deprecated
    public Builder serviceModule(ServiceModule serviceModule) {
      Preconditions.checkNotNull(serviceModule);
      return this;
    }

    public Builder applicationComponent(ApplicationComponent applicationComponent) {
      this.applicationComponent = Preconditions.checkNotNull(applicationComponent);
      return this;
    }
  }
}
