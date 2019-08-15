package com.mobven.moviesapplication.util.intentutil

import android.app.Activity
import com.mobven.moviesapplication.util.intentutil.IntentHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class IntentModule(activity: Activity) {

    private val mActivity = activity

    @Provides
    fun provideIntentHelper(): IntentHelper {
        return IntentHelper(mActivity)
    }
}