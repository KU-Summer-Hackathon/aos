package com.yjooooo.doreandroid.data.remote.repository

import com.yjooooo.doreandroid.data.remote.entity.response.BaseResponse
import com.yjooooo.doreandroid.data.remote.entity.response.HelpResponse

interface HelpRepository {
    suspend fun getHelps(): Result<BaseResponse<HelpResponse>>
}
