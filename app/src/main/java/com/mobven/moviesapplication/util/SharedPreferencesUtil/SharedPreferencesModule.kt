package com.mobven.moviesapplication.util.SharedPreferencesUtil

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class SharedPreferencesModule(context: Context, preferenceName: String, label: String) {

    private var mContext: Context = context
    private var mPreferenceName: String = preferenceName
    private var mLabel: String = label

    @Provides
    fun provideContext(): Context{
        return mContext
    }

    @Provides
    fun providePreferencesNameAndLabel(): String{
        return mPreferenceName + " " + mLabel
    }

    @Provides
    fun providesharedPreference(context: Context, preferenceAndLabel: String): SharedPreferencesHelper{
        var preferenceName = preferenceAndLabel.split(" ").get(0)
        var label = preferenceAndLabel.split(" ").get(1)
        return SharedPreferencesHelper(context, preferenceName, label)
    }

}