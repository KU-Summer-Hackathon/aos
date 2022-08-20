package com.yjooooo.doreandroid.data.local

import android.content.SharedPreferences
import timber.log.Timber
import javax.inject.Inject

class LocalPreferencesDataSourceImpl @Inject constructor(
    private val localPreferences: SharedPreferences
) : LocalPreferencesDataSource {
    override fun getAccessToken(): String {
        Timber.tag("jwt").d(localPreferences.getString(ACCESS_TOKEN, DEFAULT_STRING_VALUE))
        return localPreferences.getString(ACCESS_TOKEN, DEFAULT_STRING_VALUE) ?: DEFAULT_STRING_VALUE
    }


    override fun saveAccessToken(accessToken: String) {
        localPreferences.edit()
            .putString(ACCESS_TOKEN, accessToken)
            .apply()
    }

    companion object {
        private const val ACCESS_TOKEN = "ACCESS_TOKEN"
        const val DEFAULT_STRING_VALUE = ""
    }
}
