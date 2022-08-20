package com.yjooooo.doreandroid.presentation.intro

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.yjooooo.doreandroid.R
import com.yjooooo.doreandroid.databinding.ActivityIntroBinding
import com.yjooooo.doreandroid.presentation.auth.SignInActivity
import com.yjooooo.doreandroid.presentation.base.BaseActivity
import com.yjooooo.doreandroid.presentation.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IntroActivity : BaseActivity<ActivityIntroBinding>(R.layout.activity_intro) {
    private val introViewModel by viewModels<IntroViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startSplashLottie()
        initLottieListener()
    }

    private fun startSplashLottie() {
        binding.lottieIntro.playAnimation()
    }

    private fun initLottieListener() {
        binding.lottieIntro.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationEnd(animation: Animator?) {
                moveActivity()
            }

            override fun onAnimationStart(animation: Animator?) {}
            override fun onAnimationCancel(animation: Animator?) {}
            override fun onAnimationRepeat(animation: Animator?) {}
        })
    }

    private fun moveActivity() {
        when (introViewModel.hasToken()) {
            true -> startActivity(Intent(this, MainActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            })
            false -> startActivity(Intent(this, SignInActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            })
        }
        finish()
    }
}
