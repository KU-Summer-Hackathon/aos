package com.yjooooo.doreandroid.presentation.message

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.yjooooo.doreandroid.R
import com.yjooooo.doreandroid.data.remote.entity.response.MessageRoom
import com.yjooooo.doreandroid.databinding.ActivityMessageBinding
import com.yjooooo.doreandroid.presentation.base.BaseActivity
import com.yjooooo.doreandroid.presentation.message_room.MessageRoomActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MessageActivity : BaseActivity<ActivityMessageBinding>(R.layout.activity_message) {
    private val messageViewModel by viewModels<MessageViewModel>()
    private val messageRoomAdapter =
        MessageRoomAdapter { messageRoom -> moveMessageRoom(messageRoom) }

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

    private fun moveMessageRoom(messageRoom: MessageRoom) {
        startActivity(Intent(this, MessageRoomActivity::class.java).apply {
            putExtra("messageRoomId", messageRoom.chatId)
            putExtra("messageRoomUserName", messageRoom.userName)
        })
    }
}
