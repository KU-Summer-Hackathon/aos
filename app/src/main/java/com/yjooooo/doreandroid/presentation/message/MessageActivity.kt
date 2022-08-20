package com.yjooooo.doreandroid.presentation.message

import android.os.Bundle
import androidx.activity.viewModels
import com.yjooooo.doreandroid.R
import com.yjooooo.doreandroid.databinding.ActivityMessageBinding
import com.yjooooo.doreandroid.presentation.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MessageActivity : BaseActivity<ActivityMessageBinding>(R.layout.activity_message) {
    private val messageViewModel by viewModels<MessageViewModel>()
    private val messageRoomAdapter = MessageRoomAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        messageViewModel.getMessageRooms()
        initBackBtnClickListener()
        initMessageRoomRvAdapter()
        initMessageRoomsObserver()
    }

    private fun initBackBtnClickListener() {
        binding.btnMessageBack.setOnClickListener { finish() }
    }

    private fun initMessageRoomRvAdapter() {
        binding.rvMessageRoom.adapter = messageRoomAdapter
    }

    private fun initMessageRoomsObserver() {
        messageViewModel.messageRooms.observe(this) { messageRooms ->
            messageRoomAdapter.submitList(messageRooms)
        }
    }
}
