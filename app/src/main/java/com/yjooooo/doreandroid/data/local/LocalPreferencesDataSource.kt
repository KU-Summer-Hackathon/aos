package com.yjooooo.doreandroid.data.local

interface LocalPreferencesDataSource {
    fun getAccessToken(): String
    fun saveAccessToken(accessToken: String)
}
