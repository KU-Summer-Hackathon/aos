package com.yjooooo.doreandroid.presentation.help

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.DiffUtil
import com.yjooooo.doreandroid.data.remote.entity.response.Help
import com.yjooooo.doreandroid.data.remote.repository.HelpRepository
import com.yjooooo.doreandroid.presentation.ranking.SurroundingData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HelpViewModel @Inject constructor(
    private val helpRepository: HelpRepository
) : ViewModel() {
    private val _address = MutableLiveData<String>()
    val address: LiveData<String> = _address

    private val _helpList = MutableLiveData<List<Help>>()
    val helpList: LiveData<List<Help>> = _helpList

    fun getHelps() {
        viewModelScope.launch {
            helpRepository.getHelps()
                .onSuccess { response ->
                    Timber.tag("Help_getHelps").d(response.data.toString())
                    _address.postValue(response.data.address)
                    _helpList.postValue(response.data.helps)
                }.onFailure {
                    Timber.tag("Help_getHelps").d(it.message.toString())
                }
        }
    }


}