package com.mobven.moviesapplication.splashactivity

import com.mobven.moviesapplication.util.SharedPreferencesUtil.SharedPreferencesModule
import com.mobven.moviesapplication.util.intentutil.IntentModule
import dagger.Component

@Component(modules = [  (IntentModule::class),
                        (SplashActivityModule::class),
                        (SharedPreferencesModule::class)])
interface SplashActivityComponent {
    fun inject(splashActivity: SplashActivity)
}