package com.mobven.moviesapplication.fragment.basefragment

import com.mobven.moviesapplication.fragment.topRatedFragment.TopRatedFragmentContract
import com.mobven.moviesapplication.response.TopRatedResponse

interface BasePresenter {

    fun initializeFragment()

    fun loadData()
}