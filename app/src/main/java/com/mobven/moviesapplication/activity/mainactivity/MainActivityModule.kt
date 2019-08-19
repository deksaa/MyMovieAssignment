package com.mobven.moviesapplication.activity.mainactivity

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.mobven.moviesapplication.adapter.MainPagerAdapter
import com.mobven.moviesapplication.fragment.favoritesFragment.FavouritesFragment
import com.mobven.moviesapplication.fragment.nowPlayingFragment.NowPlayingFragment
import com.mobven.moviesapplication.fragment.topRatedFragment.TopRatedFragment
import com.mobven.moviesapplication.fragment.upcomingFragment.UpComingFragment
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule(activity: AppCompatActivity) {

    var mActivity : AppCompatActivity = activity

    @Provides
    fun provideAppCompatActivity() : AppCompatActivity{
        return mActivity
    }

    @Provides
    fun provideFragmentManager(activity: AppCompatActivity) : FragmentManager{
        return activity.supportFragmentManager
    }
    @Provides
    fun provideMainPagerAdapter(fragmentManager: FragmentManager) : MainPagerAdapter{
        var adapter = MainPagerAdapter(fragmentManager)

        adapter.addFragment(TopRatedFragment(), "Top Rated")
        adapter.addFragment(UpComingFragment(), "Up Coming")
        adapter.addFragment(NowPlayingFragment(), "Now Playing")
        adapter.addFragment(FavouritesFragment(), "Favourites")

        return adapter
    }
}