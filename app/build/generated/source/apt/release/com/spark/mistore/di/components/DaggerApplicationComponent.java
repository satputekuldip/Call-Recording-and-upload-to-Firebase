package com.spark.mistore.di.components;

import android.app.Application;
import android.content.Context;
import com.spark.mistore.QFinderApp;
import com.spark.mistore.QFinderApp_MembersInjector;
import com.spark.mistore.data.AppDataManager;
import com.spark.mistore.data.AppDataManager_Factory;
import com.spark.mistore.data.DataManager;
import com.spark.mistore.data.db.AppDbHelper;
import com.spark.mistore.data.db.AppDbHelper_Factory;
import com.spark.mistore.data.db.DbHelper;
import com.spark.mistore.data.db.DbOpenHelper;
import com.spark.mistore.data.db.DbOpenHelper_Factory;
import com.spark.mistore.data.network.ApiHeader;
import com.spark.mistore.data.network.ApiHeader_Factory;
import com.spark.mistore.data.network.ApiHeader_PublicApiHeader_Factory;
import com.spark.mistore.data.network.ApiHelper;
import com.spark.mistore.data.network.AppApiHelper;
import com.spark.mistore.data.network.AppApiHelper_Factory;
import com.spark.mistore.data.prefs.AppPreferencesHelper;
import com.spark.mistore.data.prefs.AppPreferencesHelper_Factory;
import com.spark.mistore.data.prefs.PreferencesHelper;
import com.spark.mistore.di.modules.ApplicationModule;
import com.spark.mistore.di.modules.ApplicationModule_ProvideApiHelperFactory;
import com.spark.mistore.di.modules.ApplicationModule_ProvideApiKeyFactory;
import com.spark.mistore.di.modules.ApplicationModule_ProvideApplicationFactory;
import com.spark.mistore.di.modules.ApplicationModule_ProvideCalligraphyDefaultConfigFactory;
import com.spark.mistore.di.modules.ApplicationModule_ProvideContextFactory;
import com.spark.mistore.di.modules.ApplicationModule_ProvideDataManagerFactory;
import com.spark.mistore.di.modules.ApplicationModule_ProvideDatabaseNameFactory;
import com.spark.mistore.di.modules.ApplicationModule_ProvideDbHelperFactory;
import com.spark.mistore.di.modules.ApplicationModule_ProvidePreferenceNameFactory;
import com.spark.mistore.di.modules.ApplicationModule_ProvidePreferencesHelperFactory;
import com.spark.mistore.di.modules.ApplicationModule_ProvideProtectedApiHeaderFactory;
import com.spark.mistore.services.SyncService;
import com.spark.mistore.services.SyncService_MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerApplicationComponent implements ApplicationComponent {
  private ApplicationModule applicationModule;

  private ApplicationModule_ProvideContextFactory provideContextProvider;

  private ApplicationModule_ProvideDatabaseNameFactory provideDatabaseNameProvider;

  private Provider<DbOpenHelper> dbOpenHelperProvider;

  private Provider<AppDbHelper> appDbHelperProvider;

  private Provider<DbHelper> provideDbHelperProvider;

  private ApplicationModule_ProvidePreferenceNameFactory providePreferenceNameProvider;

  private Provider<AppPreferencesHelper> appPreferencesHelperProvider;

  private Provider<PreferencesHelper> providePreferencesHelperProvider;

  private ApplicationModule_ProvideApiKeyFactory provideApiKeyProvider;

  private ApiHeader_PublicApiHeader_Factory publicApiHeaderProvider;

  private Provider<ApiHeader.ProtectedApiHeader> provideProtectedApiHeaderProvider;

  private Provider<ApiHeader> apiHeaderProvider;

  private Provider<AppApiHelper> appApiHelperProvider;

  private Provider<ApiHelper> provideApiHelperProvider;

  private Provider<AppDataManager> appDataManagerProvider;

  private Provider<DataManager> provideDataManagerProvider;

  private Provider<CalligraphyConfig> provideCalligraphyDefaultConfigProvider;

  private DaggerApplicationComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.provideContextProvider =
        ApplicationModule_ProvideContextFactory.create(builder.applicationModule);
    this.provideDatabaseNameProvider =
        ApplicationModule_ProvideDatabaseNameFactory.create(builder.applicationModule);
    this.dbOpenHelperProvider =
        DoubleCheck.provider(
            DbOpenHelper_Factory.create(provideContextProvider, provideDatabaseNameProvider));
    this.appDbHelperProvider =
        DoubleCheck.provider(AppDbHelper_Factory.create(dbOpenHelperProvider));
    this.provideDbHelperProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideDbHelperFactory.create(
                builder.applicationModule, appDbHelperProvider));
    this.providePreferenceNameProvider =
        ApplicationModule_ProvidePreferenceNameFactory.create(builder.applicationModule);
    this.appPreferencesHelperProvider =
        DoubleCheck.provider(
            AppPreferencesHelper_Factory.create(
                provideContextProvider, providePreferenceNameProvider));
    this.providePreferencesHelperProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvidePreferencesHelperFactory.create(
                builder.applicationModule, appPreferencesHelperProvider));
    this.provideApiKeyProvider =
        ApplicationModule_ProvideApiKeyFactory.create(builder.applicationModule);
    this.publicApiHeaderProvider = ApiHeader_PublicApiHeader_Factory.create(provideApiKeyProvider);
    this.provideProtectedApiHeaderProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideProtectedApiHeaderFactory.create(
                builder.applicationModule,
                provideApiKeyProvider,
                providePreferencesHelperProvider));
    this.apiHeaderProvider =
        DoubleCheck.provider(
            ApiHeader_Factory.create(publicApiHeaderProvider, provideProtectedApiHeaderProvider));
    this.appApiHelperProvider =
        DoubleCheck.provider(AppApiHelper_Factory.create(apiHeaderProvider));
    this.provideApiHelperProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideApiHelperFactory.create(
                builder.applicationModule, appApiHelperProvider));
    this.appDataManagerProvider =
        DoubleCheck.provider(
            AppDataManager_Factory.create(
                provideContextProvider,
                provideDbHelperProvider,
                providePreferencesHelperProvider,
                provideApiHelperProvider));
    this.provideDataManagerProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideDataManagerFactory.create(
                builder.applicationModule, appDataManagerProvider));
    this.provideCalligraphyDefaultConfigProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideCalligraphyDefaultConfigFactory.create(
                builder.applicationModule));
    this.applicationModule = builder.applicationModule;
  }

  @Override
  public void inject(QFinderApp QFinderApp) {
    injectQFinderApp(QFinderApp);
  }

  @Override
  public void inject(SyncService service) {
    injectSyncService(service);
  }

  @Override
  public Context context() {
    return ApplicationModule_ProvideContextFactory.proxyProvideContext(applicationModule);
  }

  @Override
  public Application application() {
    return ApplicationModule_ProvideApplicationFactory.proxyProvideApplication(applicationModule);
  }

  @Override
  public DataManager getDataManager() {
    return provideDataManagerProvider.get();
  }

  private QFinderApp injectQFinderApp(QFinderApp instance) {
    QFinderApp_MembersInjector.injectMDataManager(instance, provideDataManagerProvider.get());
    QFinderApp_MembersInjector.injectMCalligraphyConfig(
        instance, provideCalligraphyDefaultConfigProvider.get());
    return instance;
  }

  private SyncService injectSyncService(SyncService instance) {
    SyncService_MembersInjector.injectMDataManager(instance, provideDataManagerProvider.get());
    return instance;
  }

  public static final class Builder {
    private ApplicationModule applicationModule;

    private Builder() {}

    public ApplicationComponent build() {
      if (applicationModule == null) {
        throw new IllegalStateException(
            ApplicationModule.class.getCanonicalName() + " must be set");
      }
      return new DaggerApplicationComponent(this);
    }

    public Builder applicationModule(ApplicationModule applicationModule) {
      this.applicationModule = Preconditions.checkNotNull(applicationModule);
      return this;
    }
  }
}
