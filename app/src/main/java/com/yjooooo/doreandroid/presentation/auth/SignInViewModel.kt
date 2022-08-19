package com.yjooooo.doreandroid.presentation.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kakao.sdk.auth.model.OAuthToken
import com.yjooooo.doreandroid.data.remote.entity.request.SignInRequest
import com.yjooooo.doreandroid.data.remote.repository.AuthRepository
import com.yjooooo.doreandroid.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {
    private val _isSuccessKakaoLogin = MutableLiveData<Event<Boolean>>()
    val isSuccessKakaoLogin: LiveData<Event<Boolean>> = _isSuccessKakaoLogin

    private val _kakaoToken = MutableLiveData<String>()
    val kakaoToken: LiveData<String> = _kakaoToken

    private val _fcmToken = MutableLiveData<String>()
    val fcmToken: LiveData<String> = _fcmToken

    private val _isInitUserInfo = MediatorLiveData<Event<Boolean>>().apply {
        addSource(_kakaoToken) { token ->
            value = Event(token.isNotBlank() && fcmToken.value != null)
        }
        addSource(_fcmToken) { token ->
            value = Event(token.isNotBlank() && kakaoToken.value != null)
        }
    }
    val isInitUserInfo: LiveData<Event<Boolean>> = _isInitUserInfo

    private val _isSuccessSignIn = MutableLiveData<Event<Boolean>>()
    val isSuccessSignIn: LiveData<Event<Boolean>> = _isSuccessSignIn

    val kakaoLoginCallback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
        if (error != null) {
            Timber.tag("kakao").e(error, "로그인 실패")

        } else if (token != null) {
            Timber.tag("kakao").d("로그인 성공 ${token.accessToken}")
            initFcmToken()
            _kakaoToken.value = token.accessToken
            _isSuccessKakaoLogin.value = Event(true)
        }
    }

    private fun initFcmToken() {
        authRepository.getFcmToken { token -> _fcmToken.value = token }
    }

    fun postSignIn() {
        viewModelScope.launch {
            authRepository.postSignIn(
                SignInRequest(
                    fcmToken = requireNotNull(fcmToken.value),
                    socialType = "KAKAO",
                    token = requireNotNull(kakaoToken.value)
                )
            ).onSuccess { response ->
                Timber.tag("SignIn_postSignIn").d(response.data.token.accessToken)
                _isSuccessSignIn.postValue(Event(true))
            }.onFailure {
                Timber.tag("SignIn_postSignIn").d(it.message.toString())
            }
        }
    }
}
