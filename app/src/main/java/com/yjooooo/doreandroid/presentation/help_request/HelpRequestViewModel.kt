package com.yjooooo.doreandroid.presentation.help_request

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yjooooo.doreandroid.util.Event

class HelpRequestViewModel : ViewModel() {
    private val _isCancelRequest = MutableLiveData<Event<Boolean>>()
    val isCancelRequest: LiveData<Event<Boolean>> = _isCancelRequest

    fun initIsCancelRequest(isCancel: Boolean) {
        _isCancelRequest.value = Event(isCancel)
    }
}
