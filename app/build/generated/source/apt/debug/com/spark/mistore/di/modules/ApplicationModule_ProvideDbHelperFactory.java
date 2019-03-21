package com.spark.mistore.di.modules;

import com.spark.mistore.data.db.AppDbHelper;
import com.spark.mistore.data.db.DbHelper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideDbHelperFactory implements Factory<DbHelper> {
  private final ApplicationModule module;

  private final Provider<AppDbHelper> appDbHelperProvider;

  public ApplicationModule_ProvideDbHelperFactory(
      ApplicationModule module, Provider<AppDbHelper> appDbHelperProvider) {
    this.module = module;
    this.appDbHelperProvider = appDbHelperProvider;
  }

  @Override
  public DbHelper get() {
    return provideInstance(module, appDbHelperProvider);
  }

  public static DbHelper provideInstance(
      ApplicationModule module, Provider<AppDbHelper> appDbHelperProvider) {
    return proxyProvideDbHelper(module, appDbHelperProvider.get());
  }

  public static ApplicationModule_ProvideDbHelperFactory create(
      ApplicationModule module, Provider<AppDbHelper> appDbHelperProvider) {
    return new ApplicationModule_ProvideDbHelperFactory(module, appDbHelperProvider);
  }

  public static DbHelper proxyProvideDbHelper(ApplicationModule instance, AppDbHelper appDbHelper) {
    return Preconditions.checkNotNull(
        instance.provideDbHelper(appDbHelper),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
