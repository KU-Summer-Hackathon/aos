package com.yjooooo.doreandroid.presentation.help

import android.os.Bundle
import androidx.activity.viewModels
import com.yjooooo.doreandroid.R
import com.yjooooo.doreandroid.databinding.ActivityHelpBinding
import com.yjooooo.doreandroid.presentation.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HelpActivity : BaseActivity<ActivityHelpBinding>(R.layout.activity_help) {
    private val helpViewModel by viewModels<HelpViewModel>()
    private val helpAdapter = HelpAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        helpViewModel.getHelps()
        initBackBtnClickListener()
        initHelpRvAdapter()
        initHelpListObserver()
    }

    private fun initBackBtnClickListener() {
        binding.btnHelpBack.setOnClickListener { finish() }
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
