package com.mobven.moviesapplication.mainactivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import butterknife.BindView
import butterknife.ButterKnife
import com.google.android.material.tabs.TabLayout
import com.mobven.moviesapplication.R
import com.mobven.moviesapplication.adapter.MainPagerAdapter
import com.mobven.moviesapplication.fragment.favoritesFragment.FavouritesFragment
import com.mobven.moviesapplication.fragment.nowPlayingFragment.NowPlayingFragment
import com.mobven.moviesapplication.fragment.topRatedFragment.TopRatedFragment
import com.mobven.moviesapplication.fragment.upcomingFragment.UpComingFragment
import dagger.Binds
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainActivityContract.View {

    @BindView(R.id.mainVP)
    lateinit var mainViewPager: ViewPager

    @BindView(R.id.mainTL)
    lateinit var mainTabLayout: TabLayout

    @Inject
    lateinit var mPresenter: MainActivityPresenter

    @Inject
    lateinit var mainPagerAdapter : MainPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ButterKnife.bind(this)

        DaggerMainActivityComponent.builder()
            .mainActivityModule(MainActivityModule(this))
            .build().inject(this)

        mPresenter.setView(this)
        mPresenter.initializeMainActivity()
    }

    override fun finishActivity() {
        this.finish()
    }

    override fun initViews() {
        mainViewPager.setAdapter(mainPagerAdapter)
        mainTabLayout.setupWithViewPager(mainViewPager)
    }
}