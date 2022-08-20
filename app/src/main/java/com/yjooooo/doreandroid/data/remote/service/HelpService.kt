package com.yjooooo.doreandroid.data.remote.service

import com.yjooooo.doreandroid.data.remote.entity.response.BaseResponse
import com.yjooooo.doreandroid.data.remote.entity.response.HelpResponse
import retrofit2.http.GET

interface HelpService {
    @GET("help")
    suspend fun getHelps(): BaseResponse<HelpResponse>
}
