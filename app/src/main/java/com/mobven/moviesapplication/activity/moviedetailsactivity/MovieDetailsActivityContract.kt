package com.mobven.moviesapplication.activity.moviedetailsactivity

interface MovieDetailsActivityContract {

    interface View{

        fun finishActivity()

        fun initViews()

        fun showToastMessage(message: String, duration: Int)
    }

    interface Presenter{

        fun setView(view: View)

        fun initializeMovieDetailsScreen()

    }
}