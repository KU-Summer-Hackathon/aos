package com.yjooooo.doreandroid.data.remote.repository

import com.yjooooo.doreandroid.data.remote.entity.response.BaseResponse
import com.yjooooo.doreandroid.data.remote.entity.response.MessageRoom

interface MessageRepository {
    suspend fun getMessageRooms(): Result<BaseResponse<List<MessageRoom>>>
}
