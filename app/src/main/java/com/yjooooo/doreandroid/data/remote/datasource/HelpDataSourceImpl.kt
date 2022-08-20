package com.yjooooo.doreandroid.data.remote.datasource

import com.yjooooo.doreandroid.data.remote.entity.response.BaseResponse
import com.yjooooo.doreandroid.data.remote.entity.response.HelpResponse
import com.yjooooo.doreandroid.data.remote.entity.response.NoDataResponse
import com.yjooooo.doreandroid.data.remote.entity.response.OneHelp
import com.yjooooo.doreandroid.data.remote.service.HelpService
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject

class HelpDataSourceImpl @Inject constructor(
    private val helpService: HelpService
) : HelpDataSource {
    override suspend fun getHelps(): BaseResponse<HelpResponse> = helpService.getHelps()
    override suspend fun postHelpRequest(
        map: Map<String, @JvmSuppressWildcards RequestBody>,
        images: ArrayList<MultipartBody.Part>
    ): BaseResponse<Boolean> =
        helpService.postHelpRequest(map, images)

    override suspend fun getOneHelp(helpId: Int): BaseResponse<OneHelp> =
        helpService.getOneHelp(helpId)

    override suspend fun postHelpDo(helpId: Int): NoDataResponse =
        helpService.postHelpDo(helpId)
}
