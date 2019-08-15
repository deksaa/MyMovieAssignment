package com.mobven.moviesapplication.mainactivity

import dagger.Component

@Component(modules = [(MainActivityModule::class)])
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity)
}