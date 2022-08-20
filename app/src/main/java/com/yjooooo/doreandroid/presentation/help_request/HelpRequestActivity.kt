package com.yjooooo.doreandroid.presentation.help_request

import android.os.Bundle
import com.yjooooo.doreandroid.R
import com.yjooooo.doreandroid.databinding.ActivityHelpRequestBinding
import com.yjooooo.doreandroid.presentation.base.BaseActivity

class HelpRequestActivity :
    BaseActivity<ActivityHelpRequestBinding>(R.layout.activity_help_request) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initCloseBtnClickListener()
    }

    private fun initCloseBtnClickListener() {
        binding.btnHelpRequestClose.setOnClickListener {
            finish()
        }
    }
}
