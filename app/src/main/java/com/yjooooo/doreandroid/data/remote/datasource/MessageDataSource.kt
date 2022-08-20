package com.yjooooo.doreandroid.data.remote.datasource

import com.yjooooo.doreandroid.data.remote.entity.response.BaseResponse
import com.yjooooo.doreandroid.data.remote.entity.response.MessageRoom

interface MessageDataSource {
    suspend fun getMessageRooms(): BaseResponse<List<MessageRoom>>
}
