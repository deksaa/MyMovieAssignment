package com.mobven.moviesapplication.activity.moviedetailsactivity

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.mobven.moviesapplication.util.handlerutil.HandlerManager
import dagger.Module
import dagger.Provides

@Module
class MovieDetailsActivityModule(context: Context) {

    var mContext : Context = context

    @Provides
    fun provideHandlerManager(): HandlerManager {
        return HandlerManager()
    }

    @Provides
    fun provideRequestManager(): RequestManager{
        return Glide.with(mContext)
    }

}