package com.mobven.moviesapplication.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RequestTokenResponse {
    @SerializedName("success")
    @Expose
    var success: Boolean? = null
    @SerializedName("expires_at")
    @Expose
    var expiresAt: String? = null
    @SerializedName("request_token")
    @Expose
    var requestToken: String? = null
}