package com.yjooooo.doreandroid.data.remote.datasource

import com.yjooooo.doreandroid.data.remote.entity.response.BaseResponse
import com.yjooooo.doreandroid.data.remote.entity.response.Message
import com.yjooooo.doreandroid.data.remote.entity.response.MessageRoom
import com.yjooooo.doreandroid.data.remote.entity.response.NoDataResponse
import com.yjooooo.doreandroid.data.remote.service.MessageService
import javax.inject.Inject

class MessageDataSourceImpl @Inject constructor(
    private val messageService: MessageService
) : MessageDataSource {
    override suspend fun getMessageRooms(): BaseResponse<List<MessageRoom>> =
        messageService.getMessageRooms()

    override suspend fun getMessages(chatId: Int): BaseResponse<List<Message>> =
        messageService.getMessages(chatId)

    override suspend fun postAcceptHelp(messageId: Int): NoDataResponse =
        messageService.postAcceptHelp(messageId)

    override suspend fun postCompleteHelp(messageId: Int): NoDataResponse =
        messageService.postCompleteHelp(messageId)
}
