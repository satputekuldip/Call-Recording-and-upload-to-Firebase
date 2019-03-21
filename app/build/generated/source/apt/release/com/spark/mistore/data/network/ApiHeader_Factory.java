package com.spark.mistore.data.network;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApiHeader_Factory implements Factory<ApiHeader> {
  private final Provider<ApiHeader.PublicApiHeader> publicApiHeaderProvider;

  private final Provider<ApiHeader.ProtectedApiHeader> protectedApiHeaderProvider;

  public ApiHeader_Factory(
      Provider<ApiHeader.PublicApiHeader> publicApiHeaderProvider,
      Provider<ApiHeader.ProtectedApiHeader> protectedApiHeaderProvider) {
    this.publicApiHeaderProvider = publicApiHeaderProvider;
    this.protectedApiHeaderProvider = protectedApiHeaderProvider;
  }

  @Override
  public ApiHeader get() {
    return provideInstance(publicApiHeaderProvider, protectedApiHeaderProvider);
  }

  public static ApiHeader provideInstance(
      Provider<ApiHeader.PublicApiHeader> publicApiHeaderProvider,
      Provider<ApiHeader.ProtectedApiHeader> protectedApiHeaderProvider) {
    return new ApiHeader(publicApiHeaderProvider.get(), protectedApiHeaderProvider.get());
  }

  public static ApiHeader_Factory create(
      Provider<ApiHeader.PublicApiHeader> publicApiHeaderProvider,
      Provider<ApiHeader.ProtectedApiHeader> protectedApiHeaderProvider) {
    return new ApiHeader_Factory(publicApiHeaderProvider, protectedApiHeaderProvider);
  }

  public static ApiHeader newApiHeader(
      ApiHeader.PublicApiHeader publicApiHeader, ApiHeader.ProtectedApiHeader protectedApiHeader) {
    return new ApiHeader(publicApiHeader, protectedApiHeader);
  }
}
