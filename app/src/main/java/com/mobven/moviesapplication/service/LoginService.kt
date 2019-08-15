package com.mobven.moviesapplication.service

import com.mobven.moviesapplication.model.Token
import com.mobven.moviesapplication.response.RequestTokenResponse
import com.mobven.moviesapplication.response.SessionResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface LoginService {

    @GET("/3/authentication/token/new")
    fun getRequestToken(@Query("api_key") apiKey: String): Call<RequestTokenResponse>

    @POST("/3/authentication/session/new")
    fun createSession(@Query("api_key") apiKey: String, @Body token: Token): Call<SessionResponse>

//    @POST("/3/authentication/token/validate_with_login")
//    fun login(@Query("api_key") apiKey: String, @Body credential: LoginCredentialModel): Call<Token>

}