package com.mobven.moviesapplication.util.SharedPreferencesUtil

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class SharedPreferencesModule(context: Context, preferenceName: String) {

    private var mContext: Context = context
    private var mPreferenceName: String = preferenceName

    @Provides
    fun provideContext(): Context{
        return mContext
    }

    @Provides
    fun providePreferencesName(): String{
        return mPreferenceName
    }

    @Provides
    fun providesharedPreference(context: Context, preferenceName: String): SharedPreferencesHelper{
        return SharedPreferencesHelper(context, preferenceName)
    }

}