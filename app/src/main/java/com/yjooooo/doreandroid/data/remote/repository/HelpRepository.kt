package com.yjooooo.doreandroid.data.remote.repository

import com.yjooooo.doreandroid.data.remote.entity.response.BaseResponse
import com.yjooooo.doreandroid.data.remote.entity.response.HelpResponse
import com.yjooooo.doreandroid.data.remote.entity.response.NoDataResponse
import com.yjooooo.doreandroid.data.remote.entity.response.OneHelp
import okhttp3.MultipartBody
import okhttp3.RequestBody

interface HelpRepository {
    suspend fun getHelps(): Result<BaseResponse<HelpResponse>>

    suspend fun postHelpRequest(
        map: Map<String, @JvmSuppressWildcards RequestBody>,
        images: ArrayList<MultipartBody.Part>
    ): Result<BaseResponse<Boolean>>

    suspend fun getOneHelp(helpId: Int): Result<BaseResponse<OneHelp>>

    suspend fun postHelpDo(helpId: Int): Result<NoDataResponse>
}
