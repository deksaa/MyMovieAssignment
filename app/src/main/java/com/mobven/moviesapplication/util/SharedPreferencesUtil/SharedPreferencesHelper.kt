package com.mobven.moviesapplication.util.SharedPreferencesUtil

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesHelper(
    private val mContext: Context,
    private val mPreferenceName: String,
    private val mDataLabel: String) : ISharedPreference
{
    private var mSharedPreferences: SharedPreferences? = null
    private val mData: String? = null

    var payload: String?
        get() = loadPreferences()
        set(data) = savePreferences(data)

    override fun loadPreferences(): String? {
        mSharedPreferences = mContext.getSharedPreferences(mPreferenceName, Context.MODE_PRIVATE)
        return mSharedPreferences!!.getString(mDataLabel, "")
    }

    override fun savePreferences(data: String?) {
        mSharedPreferences = mContext.getSharedPreferences(mPreferenceName, Context.MODE_PRIVATE)
        val editor = mSharedPreferences!!.edit()

        editor.putString(mDataLabel, data)

        editor.commit()
    }
}
