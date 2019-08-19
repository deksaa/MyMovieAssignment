package com.mobven.moviesapplication.activity.splashactivity

interface SplashActivityContract {

    interface View{

        fun finishActivity()

        fun initViews()

        fun showToastMessage(message: String, duration: Int)
    }

    interface Presenter{

        fun setView(view: View)

        fun initializeSplashScreen()

        fun login()

        fun requestToken()

        fun createSession()
    }
}