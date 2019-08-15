package com.mobven.moviesapplication.mainactivity

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