package com.mobven.moviesapplication.repository

import com.mobven.moviesapplication.model.LoginCredentialModel
import com.mobven.moviesapplication.service.ResponseCallback
import com.mobven.moviesapplication.model.Token
import com.mobven.moviesapplication.response.RequestTokenResponse
import com.mobven.moviesapplication.response.SessionResponse

interface IRepository {

    //fun login(apiKey: String, credential: LoginCredentialModel, callback: ResponseCallback<Token>)

    fun createSession(apiKey: String, token: Token, callback: ResponseCallback<SessionResponse>)

    fun getRequestToken(apiKey: String, callback: ResponseCallback<RequestTokenResponse>)
}