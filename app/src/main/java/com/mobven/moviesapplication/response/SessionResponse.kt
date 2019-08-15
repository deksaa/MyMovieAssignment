package com.mobven.moviesapplication.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SessionResponse {

    @SerializedName("success")
    @Expose
    var success: Boolean? = null
    @SerializedName("session_id")
    @Expose
    var sessionId: String? = null

}