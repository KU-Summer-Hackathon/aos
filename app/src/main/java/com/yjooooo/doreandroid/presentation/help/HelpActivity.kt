package com.yjooooo.doreandroid.presentation.help

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.yjooooo.doreandroid.R
import com.yjooooo.doreandroid.databinding.ActivityHelpBinding
import com.yjooooo.doreandroid.presentation.base.BaseActivity
import com.yjooooo.doreandroid.presentation.help_request.HelpRequestActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HelpActivity : BaseActivity<ActivityHelpBinding>(R.layout.activity_help) {
    private val helpViewModel by viewModels<HelpViewModel>()
    private val helpAdapter = HelpAdapter { helpId -> helpViewModel.postHelpDo(helpId) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        helpViewModel.getHelps()
        initBackBtnClickListener()
        initHelpRequestBtnClickListener()
        initHelpRvAdapter()
        initHelpListObserver()
    }

    private fun initBackBtnClickListener() {
        binding.btnHelpBack.setOnClickListener { finish() }
    }

    private fun initHelpRequestBtnClickListener() {
        binding.btnHelpRequest.setOnClickListener {
            startActivity(Intent(this, HelpRequestActivity::class.java))
        }
    }

    private fun initHelpRvAdapter() {
        binding.rvHelp.adapter = helpAdapter
    }

    private fun initHelpListObserver() {
        helpViewModel.helpList.observe(this) { helpList ->
            binding.address = helpViewModel.address.value
            helpAdapter.submitList(helpList)
        }
    }
}
