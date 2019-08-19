package com.mobven.moviesapplication.fragment.nowPlayingFragment

import com.mobven.moviesapplication.util.SharedPreferencesUtil.SharedPreferencesModule
import dagger.Component

@Component(modules = [(NowPlayingFragmentModule::class),
                     (SharedPreferencesModule::class)])
interface NowPlayingFragmentComponent {
    fun inject(t: NowPlayingFragment)
}