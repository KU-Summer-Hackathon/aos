package com.yjooooo.doreandroid.presentation.help

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yjooooo.doreandroid.data.remote.entity.response.Help
import com.yjooooo.doreandroid.data.remote.entity.response.OneHelp
import com.yjooooo.doreandroid.data.remote.repository.HelpRepository
import com.yjooooo.doreandroid.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HelpViewModel @Inject constructor(
    private val helpRepository: HelpRepository
) : ViewModel() {
    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _address = MutableLiveData<String>()
    val address: LiveData<String> = _address

    private val _helpList = MutableLiveData<List<Help>>()
    val helpList: LiveData<List<Help>> = _helpList

    var oneHelpId = -1
        private set

    private val _oneHelp = MutableLiveData<OneHelp>()
    val oneHelp: LiveData<OneHelp> = _oneHelp

    private val _isSuccessPostHelp = MutableLiveData<Event<Boolean>>()
    val isSuccessPostHelp: LiveData<Event<Boolean>> = _isSuccessPostHelp

    private fun initIsLoading(isLoading: Boolean) {
        _isLoading.value = isLoading
    }

    fun initOneHelpId(helpId: Int) {
        oneHelpId = helpId
    }

    fun getHelps() {
        initIsLoading(true)
        viewModelScope.launch {
            helpRepository.getHelps()
                .onSuccess { response ->
                    Timber.tag("Help_getHelps").d(response.data.toString())
                    _address.postValue(response.data.address)
                    _helpList.postValue(response.data.helps)
                    initIsLoading(false)
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
                    Timber.tag("Help_postHelpDo").d(response.toString())
                    _isSuccessPostHelp.postValue(Event(true))
                }
                .onFailure {
                    Timber.tag("Help_postHelpDo").d(it.message.toString())
                }
        }
    }
}
