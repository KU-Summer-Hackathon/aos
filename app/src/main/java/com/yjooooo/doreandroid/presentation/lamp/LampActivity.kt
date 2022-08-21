package com.yjooooo.doreandroid.presentation.lamp

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.yjooooo.doreandroid.R
import com.yjooooo.doreandroid.databinding.ActivityLampBinding
import com.yjooooo.doreandroid.presentation.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LampActivity : BaseActivity<ActivityLampBinding>(R.layout.activity_lamp) {
    private val lampViewModel by viewModels<LampViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initLampClickListener()
    }

    private fun initLampClickListener() {
        binding.layoutLamp.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    PayActivity::class.java
                )
            )
        }
    }
}
