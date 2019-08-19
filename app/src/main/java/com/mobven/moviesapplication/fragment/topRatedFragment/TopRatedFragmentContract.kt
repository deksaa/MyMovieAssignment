package com.mobven.moviesapplication.fragment.topRatedFragment

import com.mobven.moviesapplication.fragment.basefragment.BasePresenter
import com.mobven.moviesapplication.fragment.basefragment.BaseView
import com.mobven.moviesapplication.response.TopRatedResponse

class TopRatedFragmentContract {

    interface View: BaseView
    {
        fun updateAdapter(list: ArrayList<TopRatedResponse.Result>)
    }

    interface Presenter: BasePresenter
    {
        fun setView(view: TopRatedFragmentContract.View)

        fun onItemClicked(data: TopRatedResponse.Result)
    }
}