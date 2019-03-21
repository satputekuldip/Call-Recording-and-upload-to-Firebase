package com.spark.mistore.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Created by SPARK on 01/08/2018.
 */
public class LoginUserResponse {
    @Expose
    @SerializedName("status_code")
    private String statusCode;

    @Expose
    @SerializedName("user_id")
    private Long userId;

    @Expose
    @SerializedName("login_id")
    private String loginId;


    @Expose
    @SerializedName("user_name")
    private String userName;

    @Expose
    @SerializedName("email")
    private String userEmail;

    @Expose
    @SerializedName("profile_pic")
    private String serverProfilePicUrl;

    @Expose
    @SerializedName("access_token")
    private String accessToken;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getServerProfilePicUrl() {
        return serverProfilePicUrl;
    }

    public void setServerProfilePicUrl(String serverProfilePicUrl) {
        this.serverProfilePicUrl = serverProfilePicUrl;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LoginUserResponse)) return false;
        LoginUserResponse that = (LoginUserResponse) o;
        return Objects.equals(getStatusCode(), that.getStatusCode()) &&
                Objects.equals(getUserId(), that.getUserId()) &&
                Objects.equals(getLoginId(), that.getLoginId()) &&
                Objects.equals(getUserName(), that.getUserName()) &&
                Objects.equals(getUserEmail(), that.getUserEmail()) &&
                Objects.equals(getServerProfilePicUrl(), that.getServerProfilePicUrl()) &&
                Objects.equals(getAccessToken(), that.getAccessToken());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getStatusCode(),
                getUserId(),
                getLoginId(),
                getUserName(),
                getUserEmail(),
                getServerProfilePicUrl(),
                getAccessToken());
    }

    @Override
    public String toString() {
        return "LoginUserResponse{" +
                "statusCode='" + statusCode + '\'' +
                ", userId=" + userId +
                ", loginId='" + loginId + '\'' +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", serverProfilePicUrl='" + serverProfilePicUrl + '\'' +
                ", accessToken='" + accessToken + '\'' +
                '}';
    }
}
