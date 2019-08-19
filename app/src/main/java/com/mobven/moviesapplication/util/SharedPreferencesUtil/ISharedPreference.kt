package com.mobven.moviesapplication.util.SharedPreferencesUtil

interface ISharedPreference {

    fun loadPreferences(dataLabel: String?): String?

    fun savePreferences(dataLabel: String?, data: String?)
}