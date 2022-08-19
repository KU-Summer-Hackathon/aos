package com.yjooooo.doreandroid.data.remote.datasource

import com.yjooooo.doreandroid.data.remote.entity.request.SignInRequest
import com.yjooooo.doreandroid.data.remote.entity.response.BaseResponse
import com.yjooooo.doreandroid.data.remote.entity.response.SignInResponse
import com.yjooooo.doreandroid.data.remote.service.AuthService
import javax.inject.Inject

class AuthDataSourceImpl @Inject constructor(
    private val authService: AuthService
) : AuthDataSource {
    override suspend fun postSignIn(body: SignInRequest): BaseResponse<SignInResponse> =
        authService.postSignIn(body)
}
