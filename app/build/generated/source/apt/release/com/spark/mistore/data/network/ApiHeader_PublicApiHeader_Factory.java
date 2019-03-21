package com.spark.mistore.data.network;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApiHeader_PublicApiHeader_Factory implements Factory<ApiHeader.PublicApiHeader> {
  private final Provider<String> apiKeyProvider;

  public ApiHeader_PublicApiHeader_Factory(Provider<String> apiKeyProvider) {
    this.apiKeyProvider = apiKeyProvider;
  }

  @Override
  public ApiHeader.PublicApiHeader get() {
    return provideInstance(apiKeyProvider);
  }

  public static ApiHeader.PublicApiHeader provideInstance(Provider<String> apiKeyProvider) {
    return new ApiHeader.PublicApiHeader(apiKeyProvider.get());
  }

  public static ApiHeader_PublicApiHeader_Factory create(Provider<String> apiKeyProvider) {
    return new ApiHeader_PublicApiHeader_Factory(apiKeyProvider);
  }

  public static ApiHeader.PublicApiHeader newPublicApiHeader(String apiKey) {
    return new ApiHeader.PublicApiHeader(apiKey);
  }
}
