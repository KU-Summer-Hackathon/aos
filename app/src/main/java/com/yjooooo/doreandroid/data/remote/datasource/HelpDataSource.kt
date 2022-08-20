package com.yjooooo.doreandroid.data.remote.datasource

import com.yjooooo.doreandroid.data.remote.entity.response.BaseResponse
import com.yjooooo.doreandroid.data.remote.entity.response.HelpResponse

interface HelpDataSource {
    suspend fun getHelps():BaseResponse<HelpResponse>
}
