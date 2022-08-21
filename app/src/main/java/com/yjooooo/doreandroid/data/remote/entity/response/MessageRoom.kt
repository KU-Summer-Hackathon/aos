package com.yjooooo.doreandroid.data.remote.entity.response

data class MessageRoom(
    val chatId: Int,
    val content: String,
    val read: Boolean,
    val userImageUrl: String,
    val userName: String
)
