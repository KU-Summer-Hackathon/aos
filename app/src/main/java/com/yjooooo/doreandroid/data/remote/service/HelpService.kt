package com.yjooooo.doreandroid.data.remote.service

import com.yjooooo.doreandroid.data.remote.entity.response.BaseResponse
import com.yjooooo.doreandroid.data.remote.entity.response.HelpResponse
import com.yjooooo.doreandroid.data.remote.entity.response.NoDataResponse
import com.yjooooo.doreandroid.data.remote.entity.response.OneHelp
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.PartMap
import retrofit2.http.Path
import retrofit2.http.Query

interface HelpService {
    @GET("help")
    suspend fun getHelps(): BaseResponse<HelpResponse>

    @Multipart
    @POST("help")
    suspend fun postHelpRequest(
        @PartMap map: Map<String, @JvmSuppressWildcards RequestBody>,
        @Part images: ArrayList<MultipartBody.Part>
    ): BaseResponse<String>

    @GET("help/{helpId}")
    suspend fun getOneHelp(
        @Path("helpId") helpId: Int
    ): BaseResponse<OneHelp>

    @POST("help/{helpId}")
    suspend fun postHelpDo(
        @Path("helpId") helpId: Int
    ): NoDataResponse
}
