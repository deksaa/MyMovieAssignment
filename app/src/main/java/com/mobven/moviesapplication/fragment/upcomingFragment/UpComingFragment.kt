package com.mobven.moviesapplication.fragment.upcomingFragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife

import com.mobven.moviesapplication.R
import com.mobven.moviesapplication.adapter.MovieListAdapter
import com.mobven.moviesapplication.common.EndlessRecyclerViewOnScrollListener
import com.mobven.moviesapplication.constants.Constants
import com.mobven.moviesapplication.fragment.topRatedFragment.*
import com.mobven.moviesapplication.response.TopRatedResponse
import com.mobven.moviesapplication.response.UpcomingResponse
import com.mobven.moviesapplication.util.SharedPreferencesUtil.SharedPreferencesModule
import javax.inject.Inject

class UpComingFragment : Fragment(), UpComingFragmentContract.View {

    @BindView(R.id.movieListRV)
    lateinit var movieListRV : RecyclerView

    @Inject
    lateinit var mUpComingFragmentPresenter: UpComingFragmentPresenter

    @Inject
    lateinit var mMovieListAdapter: MovieListAdapter

    @Inject
    lateinit var mLayoutManager: LinearLayoutManager

    companion object {
        fun newInstance() = UpComingFragment()
    }

    private lateinit var viewModel: UpComingViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var v = inflater.inflate(R.layout.fragment_common_movie_list, container, false)

//        DaggerUpComingFragmentComponent
//            .builder()
//            .upComingFragmentModule(UpComingFragmentModule(context!!))
//            .sharedPreferencesModule(SharedPreferencesModule(context!!, Constants.API_PREF_NAME))
//            .build()
//            .inject(this)
//
//        ButterKnife.bind(this, v)
//
//        mUpComingFragmentPresenter.setView(this)
//        mUpComingFragmentPresenter.initializeFragment()
//        mUpComingFragmentPresenter.loadData()

        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(UpComingViewModel::class.java)
        // TODO: Use the ViewModel
    }

//    override fun onItemClicked(data: UpcomingResponse.Result) {
//        mUpComingFragmentPresenter.onItemClicked(data)
//    }

    override fun initViews() {
        movieListRV.layoutManager = mLayoutManager
        movieListRV.adapter = mMovieListAdapter
        movieListRV.addOnScrollListener(object: EndlessRecyclerViewOnScrollListener(mLayoutManager){
            override fun onLoadMore() {
//                mUpComingFragmentPresenter.loadData()
            }
        })
    }

    override fun updateAdapter(list: ArrayList<UpcomingResponse.Result>) {
//        mMovieListAdapter.addAll(list)
    }

    override fun showToastMessage(message: String, duration: Int) {
        Toast.makeText(context!!, message, duration).show()
    }

}
