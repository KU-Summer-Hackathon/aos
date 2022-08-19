package com.yjooooo.doreandroid.data.remote.datasource

import com.yjooooo.doreandroid.data.remote.entity.request.SignInRequest
import com.yjooooo.doreandroid.data.remote.entity.response.BaseResponse
import com.yjooooo.doreandroid.data.remote.entity.response.SignInResponse

interface AuthDataSource {
    suspend fun postSignIn(body: SignInRequest): BaseResponse<SignInResponse>
}
