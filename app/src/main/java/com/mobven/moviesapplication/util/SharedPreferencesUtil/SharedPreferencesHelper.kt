package com.mobven.moviesapplication.util.SharedPreferencesUtil

import android.content.Context

class SharedPreferencesHelper(mContext: Context, mPreferenceName: String) : ISharedPreference
{
    private var mSharedPreferences = mContext.getSharedPreferences(mPreferenceName, Context.MODE_PRIVATE)

    override fun loadPreferences(dataLabel: String?): String? {
        return mSharedPreferences!!.getString(dataLabel, "")
    }

    override fun savePreferences(dataLabel: String?, data: String?) {
        val editor = mSharedPreferences!!.edit()

        editor.putString(dataLabel, data)

        editor.commit()
    }
}
