package com.spark.mistore.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Created by SPARK on 01/08/2018.
 */
public class LoginUserRequest {
    public LoginUserRequest(String username) {
        this.username = username;
    }

    @Expose
    @SerializedName("username")
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LoginUserRequest)) return false;
        LoginUserRequest that = (LoginUserRequest) o;
        return Objects.equals(getUsername(), that.getUsername());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getUsername());
    }
}
