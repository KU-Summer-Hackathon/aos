package com.yjooooo.doreandroid.presentation.message_room

import android.os.Bundle
import androidx.activity.viewModels
import com.yjooooo.doreandroid.R
import com.yjooooo.doreandroid.databinding.ActivityMessageRoomBinding
import com.yjooooo.doreandroid.presentation.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MessageRoomActivity :
    BaseActivity<ActivityMessageRoomBinding>(R.layout.activity_message_room) {
    private val messageRoomViewModel by viewModels<MessageRoomViewModel>()
    private val messageAdapter = MessageAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        messageRoomViewModel.getMessages(intent.getIntExtra("messageRoomId", -1))
        initMessageRoomRvAdapter()
        initBackBtnClickListener()
        initMessagesObserver()
    }

    private fun initMessageRoomRvAdapter() {
        binding.rvMessageRoomMessage.adapter = messageAdapter
    }

    private fun initBackBtnClickListener() {
        binding.btnMessageRoomBack.setOnClickListener { finish() }
    }

    private fun initMessagesObserver() {
        messageRoomViewModel.messages.observe(this) { messages ->
            messageAdapter.submitList(messages)
        }
    }
}
