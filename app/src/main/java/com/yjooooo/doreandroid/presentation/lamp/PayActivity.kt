package com.yjooooo.doreandroid.presentation.lamp

import android.os.Bundle
import android.webkit.WebViewClient
import com.yjooooo.doreandroid.R
import com.yjooooo.doreandroid.databinding.ActivityPayBinding
import com.yjooooo.doreandroid.presentation.base.BaseActivity


class PayActivity : BaseActivity<ActivityPayBinding>(R.layout.activity_pay) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.wbPay.webViewClient = WebViewClient()
        binding.wbPay.loadUrl("https://online-pay.kakao.com/mockup/v1/c3fce7094450f95a3cc637d074a277721ddfd61fdd5448d1187c73c56ff95cf0/aInfo")
    }
}
