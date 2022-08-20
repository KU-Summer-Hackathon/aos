package com.yjooooo.doreandroid.presentation.message_room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yjooooo.doreandroid.data.remote.entity.response.Message
import com.yjooooo.doreandroid.data.remote.repository.MessageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MessageRoomViewModel @Inject constructor(
    private val messageRepository: MessageRepository
) : ViewModel() {
    private val _messages = MutableLiveData<List<Message>>()
    val messages: LiveData<List<Message>> = _messages

    fun getMessages(messageRoomId: Int) {
        viewModelScope.launch {
            messageRepository.getMessages(messageRoomId)
                .onSuccess { response ->
                    Timber.tag("MessageRoom_getMessages").d(response.data.toString())
                    _messages.postValue(requireNotNull(response.data))
                }
                .onFailure {
                    Timber.tag("MessageRoom_getMessages").d(it.message.toString())
                }
        }
    }
}
