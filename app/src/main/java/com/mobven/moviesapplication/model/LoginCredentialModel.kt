package com.mobven.moviesapplication.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginCredentialModel {

    @SerializedName("username")
    @Expose
    var username: String? = null
    @SerializedName("password")
    @Expose
    var password: String? = null
    @SerializedName("request_token")
    @Expose
    var requestToken: String? = null

}