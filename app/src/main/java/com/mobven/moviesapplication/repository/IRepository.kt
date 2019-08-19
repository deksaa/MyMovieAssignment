package com.mobven.moviesapplication.repository

import com.mobven.moviesapplication.model.LoginCredentialModel
import com.mobven.moviesapplication.model.NowPlayingResponse
import com.mobven.moviesapplication.service.ResponseCallback
import com.mobven.moviesapplication.model.Token
import com.mobven.moviesapplication.response.*

interface IRepository {

    fun login(apiKey: String, credential: LoginCredentialModel, callback: ResponseCallback<LoginResponse>){}

    fun createSession(apiKey: String, token: Token, callback: ResponseCallback<SessionResponse>){}

    fun getRequestToken(apiKey: String, callback: ResponseCallback<RequestTokenResponse>){}

    fun getTopRatedMovies(apiKey: String, page: String, callback: ResponseCallback<TopRatedResponse>){}

    fun getUpcomingMovies(apiKey: String, page: String, callback: ResponseCallback<UpcomingResponse >){}

    fun getNowPlayingMovies(apiKey: String, page: String, callback: ResponseCallback<NowPlayingResponse>){}

    fun getFavouriteMovies(apiKey: String, page: String, sessionId: String, callback: ResponseCallback<FavouriteResponse>){}
}