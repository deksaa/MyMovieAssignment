package com.mobven.moviesapplication.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginCredentialModel(username: String, password: String, request_token: String) {

    @SerializedName("username")
    @Expose
    private var mUsername: String? = username
    @SerializedName("password")
    @Expose
    private var mPassword: String? = password
    @SerializedName("request_token")
    @Expose
    private var mRequestToken: String? = request_token

}