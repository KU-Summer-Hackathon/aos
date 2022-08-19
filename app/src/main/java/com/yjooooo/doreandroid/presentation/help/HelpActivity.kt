package com.yjooooo.doreandroid.presentation.help

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yjooooo.doreandroid.R
import com.yjooooo.doreandroid.databinding.ActivityHelpBinding
import com.yjooooo.doreandroid.presentation.base.BaseActivity

class HelpActivity : BaseActivity<ActivityHelpBinding>(R.layout.activity_help) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBackBtnClickListener()
    }

    private fun initBackBtnClickListener() {
        binding.btnHelpBack.setOnClickListener {
            finish()
        }
    }
}
