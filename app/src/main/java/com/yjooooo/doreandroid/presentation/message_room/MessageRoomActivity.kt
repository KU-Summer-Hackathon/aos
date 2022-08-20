package com.yjooooo.doreandroid.presentation.message_room

import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.yjooooo.doreandroid.R
import com.yjooooo.doreandroid.databinding.ActivityMessageRoomBinding
import com.yjooooo.doreandroid.presentation.base.BaseActivity
import com.yjooooo.doreandroid.util.EventObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MessageRoomActivity :
    BaseActivity<ActivityMessageRoomBinding>(R.layout.activity_message_room) {
    private val messageRoomViewModel by viewModels<MessageRoomViewModel>()
    private val messageAdapter = MessageAdapter(
        { messageId -> messageRoomViewModel.postAcceptHelp(messageId) },
        { messageId -> messageRoomViewModel.postCompleteHelp(messageId) }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.messageRoomViewModel = messageRoomViewModel
        binding.userName = intent.getStringExtra("messageRoomUserName")
        intent.getIntExtra("messageRoomId", -1).let {
            messageRoomViewModel.getMessages(it)
            messageRoomViewModel.initMessageId(it)
        }
        initMessageRoomRvAdapter()
        initBackBtnClickListener()
        initMessagesObserver()
        initIsSuccessPostObserver()
    }

    private fun initMessageRoomRvAdapter() {
        binding.rvMessageRoomMessage.adapter = messageAdapter
        binding.rvMessageRoomMessage.layoutManager = LinearLayoutManager(this).apply {
            stackFromEnd = true
            reverseLayout = false
        }
    }

    private fun initBackBtnClickListener() {
        binding.btnMessageRoomBack.setOnClickListener { finish() }
    }

    private fun initMessagesObserver() {
        messageRoomViewModel.messages.observe(this) { messages ->
            messageAdapter.submitList(messages)
        }
    }

    private fun initIsSuccessPostObserver() {
        messageRoomViewModel.isSuccessPost.observe(this, EventObserver { isSuccess ->
            if (isSuccess) {
                messageRoomViewModel.getMessages(messageRoomViewModel.messageId)
            }
        })
    }
}
