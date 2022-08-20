package com.yjooooo.doreandroid.data.remote.repository

import com.yjooooo.doreandroid.data.remote.datasource.HelpDataSource
import com.yjooooo.doreandroid.data.remote.entity.response.BaseResponse
import com.yjooooo.doreandroid.data.remote.entity.response.HelpResponse
import javax.inject.Inject

class HelpRepositoryImpl @Inject constructor(
    private val helpDataSource: HelpDataSource
) : HelpRepository {
    override suspend fun getHelps(): Result<BaseResponse<HelpResponse>> =
        kotlin.runCatching { helpDataSource.getHelps() }
}
