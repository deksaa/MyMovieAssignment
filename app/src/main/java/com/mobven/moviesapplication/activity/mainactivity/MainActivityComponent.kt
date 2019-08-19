package com.mobven.moviesapplication.activity.mainactivity

import dagger.Component

@Component(modules = [(MainActivityModule::class)])
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity)
}