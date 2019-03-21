

package com.spark.mistore.data.network;


import com.spark.mistore.data.network.model.BlogResponse;
import com.spark.mistore.data.network.model.LoginRequest;
import com.spark.mistore.data.network.model.LoginResponse;
import com.spark.mistore.data.network.model.LoginUserRequest;
import com.spark.mistore.data.network.model.LoginUserResponse;
import com.spark.mistore.data.network.model.LogoutResponse;
import com.spark.mistore.data.network.model.OpenSourceResponse;

import io.reactivex.Observable;

/**
 * Created by janisharali on 27/01/17.
 */

public interface ApiHelper {

    ApiHeader getApiHeader();

    Observable<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest request);

    Observable<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest request);

    Observable<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request);

    Observable<LoginUserResponse> doGetLoginUserApiCall(LoginUserRequest request);

    Observable<LogoutResponse> doLogoutApiCall();

    Observable<BlogResponse> getBlogApiCall();

    Observable<OpenSourceResponse> getOpenSourceApiCall();
}
