package com.yjooooo.doreandroid.data.remote.entity.response

data class Message(
    val helpContent: String,
    val messageContent: String,
    val messageId: Int,
    val type: Int,
    val userAge: Int,
    val userGender: String,
    val userImageUrl: String,
    val userName: String,
    val userPhoneNumber: String
)
