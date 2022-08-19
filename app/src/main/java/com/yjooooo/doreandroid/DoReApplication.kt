package com.yjooooo.doreandroid

import android.app.Application
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.common.util.Utility
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class DoReApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initTimber()
        // Kakao SDK 초기화
        KakaoSdk.init(this, getString(R.string.kakao_native_app_key))
        // Kakao 키 해시 호출하기
        Timber.tag("kakao_keyHash").d(Utility.getKeyHash(this))
    }
    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
