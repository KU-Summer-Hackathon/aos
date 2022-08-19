package com.yjooooo.doreandroid.presentation.auth

import android.os.Bundle
import androidx.activity.viewModels
import com.yjooooo.doreandroid.R
import com.yjooooo.doreandroid.data.remote.service.KakaoLoginService
import com.yjooooo.doreandroid.databinding.ActivitySignInBinding
import com.yjooooo.doreandroid.presentation.base.BaseActivity
import com.yjooooo.doreandroid.util.EventObserver
import com.yjooooo.doreandroid.util.showToast
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class SignInActivity : BaseActivity<ActivitySignInBinding>(R.layout.activity_sign_in) {
    @Inject
    lateinit var kakaoLoginService: KakaoLoginService
    private val signInViewModel by viewModels<SignInViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initKakaoLoginBtnClickListener()
        initIsInitUserInfoObserver()
    }

    private fun initKakaoLoginBtnClickListener() {
        binding.btnSignInKakaoLogin.setOnClickListener {
            startKakaoLogin()
        }
    }

    private fun startKakaoLogin() {
        kakaoLoginService.startKakaoLogin(signInViewModel.kakaoLoginCallback)
    }

    private fun initIsInitUserInfoObserver() {
        signInViewModel.isInitUserInfo.observe(this, EventObserver { isSuccess ->
            if (isSuccess) {
                Timber.tag("fcmToken").d(signInViewModel.fcmToken.value.toString())
                showToast("카카오 로그인 성공, 토큰 : ${signInViewModel.kakaoToken}")
                signInViewModel.postSignIn()
            } else {
                showToast(getString(R.string.sign_in_kakao_login_failure_msg))
            }
        })
    }
}
