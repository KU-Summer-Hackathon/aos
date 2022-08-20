package com.yjooooo.doreandroid.data.remote.datasource

import com.yjooooo.doreandroid.data.remote.entity.response.BaseResponse
import com.yjooooo.doreandroid.data.remote.entity.response.HelpResponse
import com.yjooooo.doreandroid.data.remote.entity.response.NoDataResponse
import com.yjooooo.doreandroid.data.remote.entity.response.OneHelp
import okhttp3.MultipartBody
import okhttp3.RequestBody

interface HelpDataSource {
    suspend fun getHelps(): BaseResponse<HelpResponse>

    suspend fun postHelpRequest(
        map: Map<String, @JvmSuppressWildcards RequestBody>,
        images: ArrayList<MultipartBody.Part>
    ): BaseResponse<Boolean>

    suspend fun getOneHelp(helpId: Int): BaseResponse<OneHelp>

    suspend fun postHelpDo(helpId: Int): NoDataResponse
}
