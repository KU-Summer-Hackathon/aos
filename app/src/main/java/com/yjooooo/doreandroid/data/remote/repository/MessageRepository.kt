package com.yjooooo.doreandroid.data.remote.repository

import com.yjooooo.doreandroid.data.remote.entity.response.BaseResponse
import com.yjooooo.doreandroid.data.remote.entity.response.Message
import com.yjooooo.doreandroid.data.remote.entity.response.MessageRoom
import com.yjooooo.doreandroid.data.remote.entity.response.NoDataResponse

interface MessageRepository {
    suspend fun getMessageRooms(): Result<BaseResponse<List<MessageRoom>>>

    suspend fun getMessages(chatId: Int): Result<BaseResponse<List<Message>>>

    suspend fun postAcceptHelp(messageId: Int): Result<NoDataResponse>

    suspend fun postCompleteHelp(messageId: Int): Result<NoDataResponse>
}
