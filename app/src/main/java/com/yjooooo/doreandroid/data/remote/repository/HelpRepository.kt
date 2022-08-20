package com.yjooooo.doreandroid.data.remote.repository

import com.yjooooo.doreandroid.data.remote.entity.response.BaseResponse
import com.yjooooo.doreandroid.data.remote.entity.response.HelpResponse
import com.yjooooo.doreandroid.data.remote.entity.response.NoDataResponse
import com.yjooooo.doreandroid.data.remote.entity.response.OneHelp
import okhttp3.MultipartBody

interface HelpRepository {
    suspend fun getHelps(): Result<BaseResponse<HelpResponse>>

    suspend fun postHelpRequest(
        content: String,
        images: ArrayList<MultipartBody.Part>
    ): Result<BaseResponse<String>>

    suspend fun getOneHelp(helpId: Int): Result<BaseResponse<OneHelp>>

    suspend fun postHelpDo(helpId: Int): Result<NoDataResponse>
}
