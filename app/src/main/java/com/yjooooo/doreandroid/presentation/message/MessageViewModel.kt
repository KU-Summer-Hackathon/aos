package com.yjooooo.doreandroid.presentation.message

import androidx.lifecycle.ViewModel
import com.yjooooo.doreandroid.data.remote.repository.MessageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MessageViewModel @Inject constructor(
    private val messageRepository: MessageRepository
) : ViewModel() {
}
