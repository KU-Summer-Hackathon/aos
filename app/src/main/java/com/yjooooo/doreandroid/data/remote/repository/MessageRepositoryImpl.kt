package com.yjooooo.doreandroid.data.remote.repository

import com.yjooooo.doreandroid.data.remote.datasource.MessageDataSource
import com.yjooooo.doreandroid.data.remote.entity.response.BaseResponse
import com.yjooooo.doreandroid.data.remote.entity.response.Message
import com.yjooooo.doreandroid.data.remote.entity.response.MessageRoom
import com.yjooooo.doreandroid.data.remote.entity.response.NoDataResponse
import javax.inject.Inject

class MessageRepositoryImpl @Inject constructor(
    private val messageDataSource: MessageDataSource
) : MessageRepository {
    override suspend fun getMessageRooms(): Result<BaseResponse<List<MessageRoom>>> =
        kotlin.runCatching { messageDataSource.getMessageRooms() }

    override suspend fun getMessages(chatId: Int): Result<BaseResponse<List<Message>>> =
        kotlin.runCatching { messageDataSource.getMessages(chatId) }

    override suspend fun postAcceptHelp(messageId: Int): Result<NoDataResponse> =
        kotlin.runCatching { messageDataSource.postAcceptHelp(messageId) }

    override suspend fun postCompleteHelp(messageId: Int): Result<NoDataResponse> =
        kotlin.runCatching { messageDataSource.postCompleteHelp(messageId) }
}
