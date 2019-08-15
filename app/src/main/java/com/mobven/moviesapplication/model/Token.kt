package com.mobven.moviesapplication.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.mobven.moviesapplication.response.RequestTokenResponse

class Token(requestToken: String?) {

    @SerializedName("request_token")
    @Expose
    private var mRequestToken: String? = requestToken

}
