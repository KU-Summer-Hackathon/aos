package com.yjooooo.doreandroid.data.remote.datasource

import com.yjooooo.doreandroid.data.remote.entity.response.BaseResponse
import com.yjooooo.doreandroid.data.remote.entity.response.HelpResponse
import com.yjooooo.doreandroid.data.remote.entity.response.NoDataResponse
import com.yjooooo.doreandroid.data.remote.entity.response.OneHelp
import okhttp3.MultipartBody

interface HelpDataSource {
    suspend fun getHelps(): BaseResponse<HelpResponse>

    suspend fun postHelpRequest(
        content: String,
        images: ArrayList<MultipartBody.Part>
    ): BaseResponse<String>

    suspend fun getOneHelp(helpId: Int): BaseResponse<OneHelp>

    suspend fun postHelpDo(helpId: Int): NoDataResponse
}
