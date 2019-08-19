package com.mobven.moviesapplication.fragment.favoritesFragment

import com.mobven.moviesapplication.fragment.basefragment.BasePresenter
import com.mobven.moviesapplication.fragment.basefragment.BaseView
import com.mobven.moviesapplication.response.FavouriteResponse

class FavouritesFragmentContract{

    interface View: BaseView
    {
        fun updateAdapter(list: ArrayList<FavouriteResponse.Result>)
    }

    interface Presenter: BasePresenter
    {
        fun setView(view: FavouritesFragmentContract.View)

        fun onItemClicked(data: FavouriteResponse.Result)
    }

}