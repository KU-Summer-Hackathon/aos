package com.yjooooo.doreandroid.presentation.message

import android.os.Bundle
import com.yjooooo.doreandroid.R
import com.yjooooo.doreandroid.databinding.ActivityMessageBinding
import com.yjooooo.doreandroid.presentation.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MessageActivity : BaseActivity<ActivityMessageBinding>(R.layout.activity_message) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
