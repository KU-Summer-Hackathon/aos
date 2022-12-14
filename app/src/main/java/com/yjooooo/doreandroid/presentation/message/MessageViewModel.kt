package com.yjooooo.doreandroid.presentation.message

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yjooooo.doreandroid.data.remote.entity.response.MessageRoom
import com.yjooooo.doreandroid.data.remote.repository.MessageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MessageViewModel @Inject constructor(
    private val messageRepository: MessageRepository
) : ViewModel() {
    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _messageRooms = MutableLiveData<List<MessageRoom>>()
    val messageRooms: LiveData<List<MessageRoom>> = _messageRooms

    private fun initIsLoading(isLoading: Boolean) {
        _isLoading.value = isLoading
    }

    fun getMessageRooms() {
        initIsLoading(true)
        viewModelScope.launch {
            messageRepository.getMessageRooms()
                .onSuccess { response ->
                    Timber.tag("Message_getMessageRooms").d(response.data.toString())
                    _messageRooms.postValue(requireNotNull(response.data))
                    initIsLoading(false)
                }
                .onFailure {
                    Timber.tag("Message_getMessageRooms").d(it.message.toString())
                }
        }
    }
}
