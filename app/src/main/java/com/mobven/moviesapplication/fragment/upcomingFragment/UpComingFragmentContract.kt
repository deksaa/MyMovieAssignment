package com.mobven.moviesapplication.fragment.upcomingFragment

import com.mobven.moviesapplication.fragment.basefragment.BasePresenter
import com.mobven.moviesapplication.fragment.basefragment.BaseView
import com.mobven.moviesapplication.response.UpcomingResponse

class UpComingFragmentContract {
    interface View: BaseView
    {
        fun updateAdapter(list: ArrayList<UpcomingResponse.Result>)
    }

    interface Presenter: BasePresenter
    {
        fun setView(view: UpComingFragmentContract.View)

        fun onItemClicked(data: UpcomingResponse.Result)
    }
}