package com.mobven.moviesapplication.repository

import androidx.annotation.NonNull
import com.mobven.moviesapplication.service.LoginService
import com.mobven.moviesapplication.service.ResponseCallback
import com.mobven.moviesapplication.api.ApiManager
import com.mobven.moviesapplication.model.LoginCredentialModel
import com.mobven.moviesapplication.model.Token
import com.mobven.moviesapplication.response.RequestTokenResponse
import com.mobven.moviesapplication.response.SessionResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class LoginRepository @Inject constructor(): IRepository {

    override fun getRequestToken(@NonNull apiKey: String, callback: ResponseCallback<RequestTokenResponse>) {
        ApiManager
            .create(LoginService::class.java)
            .getRequestToken(apiKey)
            .enqueue(object : Callback<RequestTokenResponse>{
                override fun onFailure(call: Call<RequestTokenResponse>, t: Throwable) {
                    callback.onFailure(call, t)
                }

                override fun onResponse(call: Call<RequestTokenResponse>, response: Response<RequestTokenResponse>) {
                    callback.onSuccess(call, response.body()!!)
                }
            })
    }

    override fun createSession(apiKey: String, token: Token, callback: ResponseCallback<SessionResponse>) {
        ApiManager
            .create(LoginService::class.java)
            .createSession(apiKey, token)
            .enqueue(object : Callback<SessionResponse>{
                override fun onFailure(call: Call<SessionResponse>, t: Throwable) {
                    callback.onFailure(call, t)
                }

                override fun onResponse(call: Call<SessionResponse>, response: Response<SessionResponse>) {
                    callback.onSuccess(call, response.body()!!)
                }
            })
    }
}