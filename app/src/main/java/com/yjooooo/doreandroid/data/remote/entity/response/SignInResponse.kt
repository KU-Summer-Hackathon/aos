package com.yjooooo.doreandroid.data.remote.entity.response

data class SignInResponse(
    val token: Token,
    val userId: Int
)

data class Token(
    val accessToken: String,
    val refreshToken: String
)

