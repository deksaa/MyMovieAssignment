package com.mobven.moviesapplication.service

import retrofit2.Call

interface ResponseCallback<T> {

    fun onSuccess(call: Call<T>, response: T)

    fun onFailure(call: Call<T>, t: Throwable)
}