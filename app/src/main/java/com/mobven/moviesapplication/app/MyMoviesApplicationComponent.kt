package com.mobven.moviesapplication.app

import dagger.Component

@Component
interface MyMoviesApplicationComponent {
    fun inject(app: MyMoviesApplication)
}