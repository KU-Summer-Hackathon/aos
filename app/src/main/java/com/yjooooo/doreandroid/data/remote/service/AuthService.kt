package com.yjooooo.doreandroid.data.remote.service

import com.yjooooo.doreandroid.data.remote.entity.request.SignInRequest
import com.yjooooo.doreandroid.data.remote.entity.response.BaseResponse
import com.yjooooo.doreandroid.data.remote.entity.response.SignInResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("auth/login")
    suspend fun postSignIn(
        @Body body: SignInRequest
    ): BaseResponse<SignInResponse>
}
