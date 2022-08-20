package com.yjooooo.doreandroid.data.remote.service

import com.yjooooo.doreandroid.data.remote.entity.response.BaseResponse
import com.yjooooo.doreandroid.data.remote.entity.response.MessageRoom
import retrofit2.http.GET

interface MessageService {
    @GET("chats")
    suspend fun getMessageRooms(): BaseResponse<List<MessageRoom>>
}
