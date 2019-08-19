package com.mobven.moviesapplication.fragment.topRatedFragment

import android.widget.Toast
import com.mobven.moviesapplication.adapter.MovieListAdapter
import com.mobven.moviesapplication.constants.Constants
import com.mobven.moviesapplication.repository.MovieRepository
import com.mobven.moviesapplication.response.TopRatedResponse
import com.mobven.moviesapplication.service.ResponseCallback
import com.mobven.moviesapplication.util.SharedPreferencesUtil.SharedPreferencesHelper
import retrofit2.Call
import javax.inject.Inject

class TopRatedFragmentPresenter @Inject constructor(): TopRatedFragmentContract.Presenter {

    private var pageCount = 1

    private lateinit var mView : TopRatedFragmentContract.View

    @Inject
    lateinit var mMovieRepository: MovieRepository

    @Inject
    lateinit var mSharedPreferencesHelper: SharedPreferencesHelper

    override fun setView(view: TopRatedFragmentContract.View) {
        this.mView = view
    }

    override fun initializeFragment() {
        mView.initViews()
    }

    override fun loadData() {
        mMovieRepository.getTopRatedMovies(mSharedPreferencesHelper.loadPreferences(Constants.API_KEY)!!, pageCount.toString(), object :
            ResponseCallback<TopRatedResponse> {
            override fun onSuccess(call: Call<TopRatedResponse>, response: TopRatedResponse) {
                pageCount++
                mView.updateAdapter(response.results as ArrayList<TopRatedResponse.Result>)
            }

            override fun onFailure(call: Call<TopRatedResponse>, t: Throwable) {
                mView.showToastMessage(t.localizedMessage, Toast.LENGTH_LONG)
            }
        })
    }

    override fun onItemClicked(data: TopRatedResponse.Result) {

    }
}