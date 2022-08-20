package com.yjooooo.doreandroid.data.remote.entity.response

data class HelpResponse(
    val address: String,
    val helps: List<Help>
)

data class Help(
    val helpId: Int,
    val requested: Boolean,
    val content: String,
    val helpImageUrls: List<String>,
    val userImageUrl: String,
    val userName: String
)

