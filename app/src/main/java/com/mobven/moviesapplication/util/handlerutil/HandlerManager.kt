package com.mobven.moviesapplication.util.handlerutil

import android.os.Handler

class HandlerManager {

    companion object{
        val DURATION = 1500L
    }

    fun providePostDelayedHandler(callback: HandlerCallback)
    {
        Handler().postDelayed({ callback.onCompleted() }, DURATION)
    }
}