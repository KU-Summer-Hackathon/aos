package com.yjooooo.doreandroid.data.remote.repository

import com.yjooooo.doreandroid.data.remote.datasource.MessageDataSource
import javax.inject.Inject

class MessageRepositoryImpl @Inject constructor(
    private val messageDataSource: MessageDataSource
) : MessageRepository {
}
