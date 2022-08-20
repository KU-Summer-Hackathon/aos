package com.yjooooo.doreandroid.presentation.help

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yjooooo.doreandroid.data.remote.entity.response.Help
import com.yjooooo.doreandroid.data.remote.entity.response.OneHelp
import com.yjooooo.doreandroid.data.remote.repository.HelpRepository
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

    var oneHelpId = -1
        private set

    private val _oneHelp = MutableLiveData<OneHelp>()
    val oneHelp: LiveData<OneHelp> = _oneHelp

    fun initOneHelpId(helpId: Int) {
        oneHelpId = helpId
    }

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

    fun getOneHelp(helpId: Int) {
        viewModelScope.launch {
            helpRepository.getOneHelp(helpId)
                .onSuccess { response ->
                    Timber.tag("Help_getOneHelp").d(response.toString())
                    _oneHelp.postValue(requireNotNull(response.data))
                }
                .onFailure {
                    Timber.tag("Help_getOneHelp").d(it.message.toString())
                }
        }
    }

    fun postHelpDo(helpId: Int) {
        viewModelScope.launch {
            helpRepository.postHelpDo(helpId)
                .onSuccess { response ->
                    Timber.tag("Help_getOneHelp").d(response.toString())
                }
                .onFailure {
                    Timber.tag("Help_getOneHelp").d(it.message.toString())
                }
        }
    }
}
