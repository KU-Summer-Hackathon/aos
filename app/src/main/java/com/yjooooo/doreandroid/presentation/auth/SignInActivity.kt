package com.yjooooo.doreandroid.presentation.auth

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.yjooooo.doreandroid.R
import com.yjooooo.doreandroid.data.remote.service.KakaoLoginService
import com.yjooooo.doreandroid.databinding.ActivitySignInBinding
import com.yjooooo.doreandroid.presentation.base.BaseActivity
import com.yjooooo.doreandroid.presentation.main.MainActivity
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
        initIsSuccessKakaoLoginObserver()
        initIsInitUserInfoObserver()
        initIsSuccessSignInObserver()
    }

    private fun initKakaoLoginBtnClickListener() {
        binding.btnSignInKakaoLogin.setOnClickListener {
            startKakaoLogin()
        }
    }

    private fun startKakaoLogin() {
        kakaoLoginService.startKakaoLogin(signInViewModel.kakaoLoginCallback)
    }

    private fun initIsSuccessKakaoLoginObserver() {
        signInViewModel.isSuccessKakaoLogin.observe(this, EventObserver { isSuccess ->
            if (isSuccess) {
                Timber.tag("fcmToken").d(signInViewModel.fcmToken.value.toString())
                Timber.tag("카카오 로그인 성공").d("토큰 : ${signInViewModel.kakaoToken}")
            } else {
                showToast(getString(R.string.sign_in_kakao_login_failure_msg))
            }
        })
    }

    private fun initIsInitUserInfoObserver() {
        signInViewModel.isInitUserInfo.observe(this, EventObserver { isSuccess ->
            if (isSuccess) {
                signInViewModel.postSignIn()
            }
        })
    }

    private fun initIsSuccessSignInObserver() {
        signInViewModel.isSuccessSignIn.observe(this, EventObserver { isSuccess ->
            Timber.tag("isSuccess").d(isSuccess.toString())
            if (isSuccess) {
                showToast(getString(R.string.sign_in_complete_login_msg))
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                showToast(getString(R.string.sign_in_sign_in_failure_msg))
            }
        })
    }
}
