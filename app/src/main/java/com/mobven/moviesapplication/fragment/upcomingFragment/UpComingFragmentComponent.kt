package com.mobven.moviesapplication.fragment.upcomingFragment

import com.mobven.moviesapplication.util.SharedPreferencesUtil.SharedPreferencesModule
import dagger.Component

@Component(modules = [(UpComingFragmentModule::class),
                      (SharedPreferencesModule::class)])
interface UpComingFragmentComponent {
    fun inject(t: UpComingFragment)
}