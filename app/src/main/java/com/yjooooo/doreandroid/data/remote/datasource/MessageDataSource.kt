package com.yjooooo.doreandroid.data.remote.datasource

import com.yjooooo.doreandroid.data.remote.entity.response.BaseResponse
import com.yjooooo.doreandroid.data.remote.entity.response.Message
import com.yjooooo.doreandroid.data.remote.entity.response.MessageRoom
import com.yjooooo.doreandroid.data.remote.entity.response.NoDataResponse

interface MessageDataSource {
    suspend fun getMessageRooms(): BaseResponse<List<MessageRoom>>

    suspend fun getMessages(chatId: Int): BaseResponse<List<Message>>

    suspend fun postAcceptHelp(messageId: Int): NoDataResponse

    suspend fun postCompleteHelp(messageId: Int): NoDataResponse
}
