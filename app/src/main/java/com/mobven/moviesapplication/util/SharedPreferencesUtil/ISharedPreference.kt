package com.mobven.moviesapplication.util.SharedPreferencesUtil

interface ISharedPreference {

    fun loadPreferences(): String?

    fun savePreferences(data: String?)
}