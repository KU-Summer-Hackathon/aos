package com.yjooooo.doreandroid.data.remote.repository

import com.yjooooo.doreandroid.data.remote.entity.request.SignInRequest
import com.yjooooo.doreandroid.data.remote.entity.response.BaseResponse
import com.yjooooo.doreandroid.data.remote.entity.response.SignInResponse

interface AuthRepository {
    fun saveAccessToken(accessToken: String)

    fun getFcmToken(getFcmToken: (String) -> Unit)

    suspend fun postSignIn(body: SignInRequest): Result<BaseResponse<SignInResponse>>
}
