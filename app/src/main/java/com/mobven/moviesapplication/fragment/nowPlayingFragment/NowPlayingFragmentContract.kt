package com.mobven.moviesapplication.fragment.nowPlayingFragment

import com.mobven.moviesapplication.fragment.basefragment.BasePresenter
import com.mobven.moviesapplication.fragment.basefragment.BaseView
import com.mobven.moviesapplication.model.NowPlayingResponse

class NowPlayingFragmentContract {

    interface View: BaseView
    {
        fun updateAdapter(list: ArrayList<NowPlayingResponse.Result>)
    }

    interface Presenter: BasePresenter
    {
        fun setView(view: NowPlayingFragmentContract.View)

        fun onItemClicked(data: NowPlayingResponse.Result)
    }
}