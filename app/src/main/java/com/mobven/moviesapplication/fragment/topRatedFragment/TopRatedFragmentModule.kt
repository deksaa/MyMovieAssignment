package com.mobven.moviesapplication.fragment.topRatedFragment

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobven.moviesapplication.adapter.MovieListAdapter
import com.mobven.moviesapplication.fragment.basefragment.BaseFragmentModule
import com.mobven.moviesapplication.response.TopRatedResponse
import dagger.Module
import dagger.Provides

@Module
class TopRatedFragmentModule(context: Context): BaseFragmentModule(context)