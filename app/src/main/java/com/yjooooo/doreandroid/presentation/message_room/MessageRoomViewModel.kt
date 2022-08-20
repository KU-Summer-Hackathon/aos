package com.yjooooo.doreandroid.presentation.message_room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yjooooo.doreandroid.data.remote.entity.response.Message
import com.yjooooo.doreandroid.data.remote.repository.MessageRepository
import com.yjooooo.doreandroid.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MessageRoomViewModel @Inject constructor(
    private val messageRepository: MessageRepository
) : ViewModel() {
    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    var messageId: Int = -1
        private set

    private val _messages = MutableLiveData<List<Message>>()
    val messages: LiveData<List<Message>> = _messages

    private val _isSuccessPost = MutableLiveData<Event<Boolean>>()
    val isSuccessPost: LiveData<Event<Boolean>> = _isSuccessPost

    fun initMessageId(messageId: Int) {
        this.messageId = messageId
    }

    private fun initIsLoading(isLoading: Boolean) {
        _isLoading.value = isLoading
    }

    fun getMessages(messageRoomId: Int) {
        initIsLoading(true)
        viewModelScope.launch {
            messageRepository.getMessages(messageRoomId)
                .onSuccess { response ->
                    Timber.tag("MessageRoom_getMessages").d(response.data.toString())
                    _messages.postValue(requireNotNull(response.data))
                    initIsLoading(false)
                }
                .onFailure {
                    Timber.tag("MessageRoom_getMessages").d(it.message.toString())
                }
        }
    }

    fun postAcceptHelp(messageId: Int) {
        viewModelScope.launch {
            messageRepository.postAcceptHelp(messageId)
                .onSuccess { response ->
                    Timber.tag("MessageRoom_postAcceptHelp").d(response.message.toString())
                    _isSuccessPost.postValue(Event(true))
                }
                .onFailure {
                    Timber.tag("MessageRoom_postAcceptHelp").d(it.message.toString())
                }
        }
    }

    fun postCompleteHelp(messageId: Int) {
        viewModelScope.launch {
            messageRepository.postCompleteHelp(messageId)
                .onSuccess { response ->
                    Timber.tag("MessageRoom_postCompleteHelp").d(response.message.toString())
                    _isSuccessPost.postValue(Event(true))
                }
                .onFailure {
                    Timber.tag("MessageRoom_postCompleteHelp").d(it.message.toString())
                }
        }
    }
}
