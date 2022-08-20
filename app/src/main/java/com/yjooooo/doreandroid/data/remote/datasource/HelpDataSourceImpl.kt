package com.yjooooo.doreandroid.data.remote.datasource

import com.yjooooo.doreandroid.data.remote.entity.response.BaseResponse
import com.yjooooo.doreandroid.data.remote.entity.response.HelpResponse
import com.yjooooo.doreandroid.data.remote.service.HelpService
import javax.inject.Inject

class HelpDataSourceImpl @Inject constructor(
    private val helpService: HelpService
) : HelpDataSource {
    override suspend fun getHelps(): BaseResponse<HelpResponse> = helpService.getHelps()
}
