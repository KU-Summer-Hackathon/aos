package com.yjooooo.doreandroid.presentation.intro

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yjooooo.doreandroid.data.local.LocalPreferencesDataSource
import com.yjooooo.doreandroid.data.local.LocalPreferencesDataSourceImpl.Companion.DEFAULT_STRING_VALUE
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class IntroViewModel @Inject constructor(
    private val localPreferencesDataSource: LocalPreferencesDataSource
) : ViewModel() {
    fun hasToken() = localPreferencesDataSource.getAccessToken() != DEFAULT_STRING_VALUE
}
