package com.yjooooo.doreandroid.presentation.help_request

import android.os.Bundle
import androidx.activity.viewModels
import com.yjooooo.doreandroid.R
import com.yjooooo.doreandroid.databinding.ActivityHelpRequestBinding
import com.yjooooo.doreandroid.presentation.base.BaseActivity
import com.yjooooo.doreandroid.util.EventObserver

class HelpRequestActivity :
    BaseActivity<ActivityHelpRequestBinding>(R.layout.activity_help_request) {
    private val helpRequestViewModel by viewModels<HelpRequestViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initCloseBtnClickListener()
        initIsCancelRequestObserver()
    }

    private fun initCloseBtnClickListener() {
        binding.btnHelpRequestClose.setOnClickListener {
            HelpRequestDialogFragment().show(supportFragmentManager, this.javaClass.name)
        }
    }

    private fun initIsCancelRequestObserver() {
        helpRequestViewModel.isCancelRequest.observe(this, EventObserver { isCancel ->
            if (isCancel) {
                finish()
            }
        })
    }
}
