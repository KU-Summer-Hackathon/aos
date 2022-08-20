package com.yjooooo.doreandroid.data.remote.repository

import com.yjooooo.doreandroid.data.remote.datasource.HelpDataSource
import com.yjooooo.doreandroid.data.remote.entity.response.BaseResponse
import com.yjooooo.doreandroid.data.remote.entity.response.HelpResponse
import com.yjooooo.doreandroid.data.remote.entity.response.NoDataResponse
import com.yjooooo.doreandroid.data.remote.entity.response.OneHelp
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject

class HelpRepositoryImpl @Inject constructor(
    private val helpDataSource: HelpDataSource
) : HelpRepository {
    override suspend fun getHelps(): Result<BaseResponse<HelpResponse>> =
        kotlin.runCatching { helpDataSource.getHelps() }

    override suspend fun postHelpRequest(
        map: Map<String, @JvmSuppressWildcards RequestBody>,
        images: ArrayList<MultipartBody.Part>
    ): Result<BaseResponse<Boolean>> =
        kotlin.runCatching { helpDataSource.postHelpRequest(map, images) }

    override suspend fun getOneHelp(helpId: Int): Result<BaseResponse<OneHelp>> =
        kotlin.runCatching { helpDataSource.getOneHelp(helpId) }

    override suspend fun postHelpDo(helpId: Int): Result<NoDataResponse> =
        kotlin.runCatching { helpDataSource.postHelpDo(helpId) }
}
