package com.mobven.moviesapplication.repository

import androidx.annotation.NonNull
import com.mobven.moviesapplication.api.ApiManager
import com.mobven.moviesapplication.model.NowPlayingResponse
import com.mobven.moviesapplication.response.FavouriteResponse
import com.mobven.moviesapplication.response.TopRatedResponse
import com.mobven.moviesapplication.response.UpcomingResponse
import com.mobven.moviesapplication.service.MovieService
import com.mobven.moviesapplication.service.ResponseCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MovieRepository @Inject constructor(): IRepository {

    override fun getTopRatedMovies(@NonNull apiKey: String,@NonNull page: String,@NonNull callback: ResponseCallback<TopRatedResponse>) {
        ApiManager
            .create(MovieService::class.java)
            .getTopRatedMovies(apiKey, page)
            .enqueue(object : Callback<TopRatedResponse>{
                override fun onFailure(call: Call<TopRatedResponse>, t: Throwable) {
                    callback.onFailure(call, t)
                }

                override fun onResponse(call: Call<TopRatedResponse>, response: Response<TopRatedResponse>) {
                    callback.onSuccess(call, response.body()!!)
                }
            })
    }

    override fun getUpcomingMovies(@NonNull apiKey: String,@NonNull page: String,@NonNull callback: ResponseCallback<UpcomingResponse>) {
        ApiManager
            .create(MovieService::class.java)
            .getUpcomingMovies(apiKey, page)
            .enqueue(object : Callback<UpcomingResponse>{
                override fun onFailure(call: Call<UpcomingResponse>, t: Throwable) {
                    callback.onFailure(call, t)
                }

                override fun onResponse(call: Call<UpcomingResponse>, response: Response<UpcomingResponse>) {
                    callback.onSuccess(call, response.body()!!)
                }
            })
    }

    override fun getNowPlayingMovies(@NonNull apiKey: String,@NonNull page: String,@NonNull callback: ResponseCallback<NowPlayingResponse>) {
        ApiManager
            .create(MovieService::class.java)
            .getNowPlayingMovies(apiKey, page)
            .enqueue(object : Callback<NowPlayingResponse>{
                override fun onFailure(call: Call<NowPlayingResponse>, t: Throwable) {
                    callback.onFailure(call, t)
                }

                override fun onResponse(call: Call<NowPlayingResponse>, response: Response<NowPlayingResponse>) {
                    callback.onSuccess(call, response.body()!!)
                }
            })
    }

    override fun getFavouriteMovies(@NonNull apiKey: String,@NonNull page: String,@NonNull sessionId: String,@NonNull callback: ResponseCallback<FavouriteResponse>) {
        ApiManager
            .create(MovieService::class.java)
            .getFavouriteMovies(apiKey, page, sessionId)
            .enqueue(object : Callback<FavouriteResponse>{
                override fun onFailure(call: Call<FavouriteResponse>, t: Throwable) {
                    callback.onFailure(call, t)
                }

                override fun onResponse(call: Call<FavouriteResponse>, response: Response<FavouriteResponse>) {
                    callback.onSuccess(call, response.body()!!)
                }
            })
    }
}