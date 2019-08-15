package com.mobven.moviesapplication.api

import com.google.gson.GsonBuilder
import com.mobven.moviesapplication.constants.ApiEndPoints
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiManager {

    companion object {

        private var interceptor: HttpLoggingInterceptor? = null
        private var httpClient: OkHttpClient? = null

        private var retrofit: Retrofit? = null

        fun <T> create(retroClass: Class<T>): T {

            if (retrofit == null)
            {
                interceptor = HttpLoggingInterceptor()
                interceptor?.level = HttpLoggingInterceptor.Level.BODY

                httpClient = OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .connectTimeout(1, TimeUnit.MINUTES)
                    .readTimeout(1, TimeUnit.MINUTES)
                    .writeTimeout(1, TimeUnit.MINUTES)
                    .build()

                val gson = GsonBuilder().setLenient().create()

                retrofit = Retrofit.Builder()
                    .client(httpClient)
                    .baseUrl(ApiEndPoints.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
            }

            return retrofit!!.create(retroClass)
        }
    }
}