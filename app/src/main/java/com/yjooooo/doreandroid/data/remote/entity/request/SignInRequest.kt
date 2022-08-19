package com.yjooooo.doreandroid.data.remote.entity.request

data class SignInRequest(
    val fcmToken: String,
    val socialType: String,
    val token: String
)
