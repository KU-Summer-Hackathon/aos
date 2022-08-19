package com.yjooooo.doreandroid.data.local

import android.content.SharedPreferences
import javax.inject.Inject

class LocalPreferencesDataSourceImpl @Inject constructor(
    private val localPreferences: SharedPreferences
) : LocalPreferencesDataSource {
    override fun getAccessToken(): String = ""
}
