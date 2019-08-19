package com.mobven.moviesapplication.service

import com.mobven.moviesapplication.model.NowPlayingResponse
import com.mobven.moviesapplication.response.FavouriteResponse
import com.mobven.moviesapplication.response.RequestTokenResponse
import com.mobven.moviesapplication.response.TopRatedResponse
import com.mobven.moviesapplication.response.UpcomingResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("/3/movie/top_rated")
    fun getTopRatedMovies(@Query("api_key") apiKey: String, @Query("page") page: String): Call<TopRatedResponse>

    @GET("/3/movie/upcoming")
    fun getUpcomingMovies(@Query("api_key") apiKey: String, @Query("page") page: String): Call<UpcomingResponse>

    @GET("/3/movie/now_playing")
    fun getNowPlayingMovies(@Query("api_key") apiKey: String, @Query("page") page: String): Call<NowPlayingResponse>

    @GET("/3/account/favorite/movies")
    fun getFavouriteMovies(@Query("api_key") apiKey: String, @Query("session_id") sessionId: String, @Query("page") page: String): Call<FavouriteResponse>
}