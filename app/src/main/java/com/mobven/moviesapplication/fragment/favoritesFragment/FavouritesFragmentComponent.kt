package com.mobven.moviesapplication.fragment.favoritesFragment

import com.mobven.moviesapplication.util.SharedPreferencesUtil.SharedPreferencesModule
import dagger.Component

@Component(modules = [(FavouritesFragmentModule::class),
                     (SharedPreferencesModule::class)])
interface FavouritesFragmentComponent{
    fun inject(favouritesFragment: FavouritesFragment)
}