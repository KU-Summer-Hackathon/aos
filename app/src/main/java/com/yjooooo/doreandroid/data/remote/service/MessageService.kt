package com.yjooooo.doreandroid.data.remote.service

import com.yjooooo.doreandroid.data.remote.entity.response.BaseResponse
import com.yjooooo.doreandroid.data.remote.entity.response.Message
import com.yjooooo.doreandroid.data.remote.entity.response.MessageRoom
import com.yjooooo.doreandroid.data.remote.entity.response.NoDataResponse
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MessageService {
    @GET("chats")
    suspend fun getMessageRooms(): BaseResponse<List<MessageRoom>>

    @GET("chat/{chatId}/messages")
    suspend fun getMessages(
        @Path("chatId") chatId: Int
    ): BaseResponse<List<Message>>

    @POST("message/{messageId}/help/accept")
    suspend fun postAcceptHelp(
        @Path("messageId") messageId: Int
    ): NoDataResponse

    @POST("message/{messageId}/help/complete")
    suspend fun postCompleteHelp(
        @Path("messageId") messageId: Int
    ): NoDataResponse
}
