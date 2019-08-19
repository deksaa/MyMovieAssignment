package com.mobven.moviesapplication.activity.mainactivity

class MainActivityContract {

    interface View{

        fun finishActivity()

        fun initViews()
    }

    interface Presenter{

        fun setView(view: View)

        fun initializeMainActivity()
    }

}