package com.yjooooo.doreandroid.data.remote.repository

import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import com.yjooooo.doreandroid.data.local.LocalPreferencesDataSource
import com.yjooooo.doreandroid.data.remote.datasource.AuthDataSource
import com.yjooooo.doreandroid.data.remote.entity.request.SignInRequest
import com.yjooooo.doreandroid.data.remote.entity.response.BaseResponse
import com.yjooooo.doreandroid.data.remote.entity.response.SignInResponse
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val localPreferencesDataSource: LocalPreferencesDataSource,
    private val authDataSource: AuthDataSource
) : AuthRepository {
    override fun saveAccessToken(accessToken: String) {
        localPreferencesDataSource.saveAccessToken(accessToken)
    }

    override fun getFcmToken(getFcmToken: (String) -> Unit) {
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            getFcmToken(requireNotNull(task.result))
        })
    }

    override suspend fun postSignIn(body: SignInRequest): Result<BaseResponse<SignInResponse>> =
        kotlin.runCatching { authDataSource.postSignIn(body) }

}
