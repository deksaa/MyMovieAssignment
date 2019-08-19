package com.mobven.moviesapplication.fragment.topRatedFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.mobven.moviesapplication.adapter.MovieListAdapter
import com.mobven.moviesapplication.common.EndlessRecyclerViewOnScrollListener
import com.mobven.moviesapplication.constants.Constants
import com.mobven.moviesapplication.response.TopRatedResponse
import com.mobven.moviesapplication.util.SharedPreferencesUtil.SharedPreferencesModule
import javax.inject.Inject


class TopRatedFragment : Fragment(), TopRatedFragmentContract.View, MovieListAdapter.ItemClickedListener{

    @BindView(com.mobven.moviesapplication.R.id.movieListRV)
    lateinit var movieListRV : RecyclerView

    @Inject
    lateinit var mTopRatedFragmentPresenter: TopRatedFragmentPresenter

    @Inject
    lateinit var mMovieListAdapter: MovieListAdapter

    @Inject
    lateinit var mLayoutManager: LinearLayoutManager

    companion object {
        fun newInstance() = TopRatedFragment()
    }

    private lateinit var viewModel: TopRatedFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var v = inflater.inflate(com.mobven.moviesapplication.R.layout.fragment_common_movie_list, container, false)

        DaggerTopRatedFragmentComponent
            .builder()
            .topRatedFragmentModule(TopRatedFragmentModule(context!!))
            .sharedPreferencesModule(SharedPreferencesModule(context!!, Constants.API_PREF_NAME))
            .build()
            .inject(this)

        ButterKnife.bind(this, v)

        mTopRatedFragmentPresenter.setView(this)
        mTopRatedFragmentPresenter.initializeFragment()
        mTopRatedFragmentPresenter.loadData()

        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TopRatedFragmentViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onItemClicked(data: TopRatedResponse.Result) {
        this.showToastMessage(data.title!!, Toast.LENGTH_SHORT)
    }

    override fun initViews() {
        movieListRV.layoutManager = mLayoutManager
        movieListRV.adapter = mMovieListAdapter
        movieListRV.addOnScrollListener(object: EndlessRecyclerViewOnScrollListener(mLayoutManager){
            override fun onLoadMore() {
                mTopRatedFragmentPresenter.loadData()
            }
        })
        mMovieListAdapter.setItemClickListener(this)
    }

    override fun updateAdapter(list: ArrayList<TopRatedResponse.Result>) {
        mMovieListAdapter.addAll(list)
    }

    override fun showToastMessage(message: String, duration: Int) {
        Toast.makeText(context!!, message, duration).show()
    }
}
