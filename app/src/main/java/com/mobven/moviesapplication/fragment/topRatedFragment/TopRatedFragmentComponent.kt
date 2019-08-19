package com.mobven.moviesapplication.fragment.topRatedFragment

import com.mobven.moviesapplication.util.SharedPreferencesUtil.SharedPreferencesModule
import dagger.Component

@Component(modules = [(TopRatedFragmentModule::class),
                     (SharedPreferencesModule::class)])
interface TopRatedFragmentComponent {
    fun inject(t: TopRatedFragment)
}