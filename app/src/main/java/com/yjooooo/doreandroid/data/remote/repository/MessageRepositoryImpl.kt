package com.yjooooo.doreandroid.data.remote.repository

import com.yjooooo.doreandroid.data.remote.datasource.MessageDataSource
import com.yjooooo.doreandroid.data.remote.entity.response.BaseResponse
import com.yjooooo.doreandroid.data.remote.entity.response.MessageRoom
import javax.inject.Inject

class MessageRepositoryImpl @Inject constructor(
    private val messageDataSource: MessageDataSource
) : MessageRepository {
    override suspend fun getMessageRooms(): Result<BaseResponse<List<MessageRoom>>> =
        kotlin.runCatching { messageDataSource.getMessageRooms() }
}
