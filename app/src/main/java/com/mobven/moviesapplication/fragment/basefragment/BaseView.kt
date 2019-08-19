package com.mobven.moviesapplication.fragment.basefragment

import com.mobven.moviesapplication.response.TopRatedResponse

interface BaseView {

    fun initViews()

    fun showToastMessage(message: String, duration: Int)

}