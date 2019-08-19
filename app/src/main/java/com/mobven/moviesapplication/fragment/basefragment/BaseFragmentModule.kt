package com.mobven.moviesapplication.fragment.basefragment

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobven.moviesapplication.adapter.MovieListAdapter
import com.mobven.moviesapplication.response.TopRatedResponse
import dagger.Module
import dagger.Provides

@Module
abstract class BaseFragmentModule(context: Context) {

    private var mContext = context

    @Provides
    fun provideEmptyData(): ArrayList<TopRatedResponse.Result>{
        return ArrayList()
    }

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager {
        return LinearLayoutManager(mContext)
    }

    @Provides
    fun provideMovieListAdapter(context: Context, list: ArrayList<TopRatedResponse.Result>): MovieListAdapter {
        return MovieListAdapter(context, list)
    }
}