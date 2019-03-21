package com.spark.mistore.di.modules;

import com.spark.mistore.data.AppDataManager;
import com.spark.mistore.data.DataManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideDataManagerFactory implements Factory<DataManager> {
  private final ApplicationModule module;

  private final Provider<AppDataManager> appDataManagerProvider;

  public ApplicationModule_ProvideDataManagerFactory(
      ApplicationModule module, Provider<AppDataManager> appDataManagerProvider) {
    this.module = module;
    this.appDataManagerProvider = appDataManagerProvider;
  }

  @Override
  public DataManager get() {
    return provideInstance(module, appDataManagerProvider);
  }

  public static DataManager provideInstance(
      ApplicationModule module, Provider<AppDataManager> appDataManagerProvider) {
    return proxyProvideDataManager(module, appDataManagerProvider.get());
  }

  public static ApplicationModule_ProvideDataManagerFactory create(
      ApplicationModule module, Provider<AppDataManager> appDataManagerProvider) {
    return new ApplicationModule_ProvideDataManagerFactory(module, appDataManagerProvider);
  }

  public static DataManager proxyProvideDataManager(
      ApplicationModule instance, AppDataManager appDataManager) {
    return Preconditions.checkNotNull(
        instance.provideDataManager(appDataManager),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
