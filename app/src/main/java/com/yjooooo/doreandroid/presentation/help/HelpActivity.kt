package com.yjooooo.doreandroid.presentation.help

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.yjooooo.doreandroid.R
import com.yjooooo.doreandroid.databinding.ActivityHelpBinding
import com.yjooooo.doreandroid.presentation.base.BaseActivity
import com.yjooooo.doreandroid.presentation.help_request.HelpRequestActivity
import com.yjooooo.doreandroid.util.EventObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HelpActivity : BaseActivity<ActivityHelpBinding>(R.layout.activity_help) {
    private val helpViewModel by viewModels<HelpViewModel>()
    private val helpAdapter = HelpAdapter(
        { helpId -> helpViewModel.initOneHelpId(helpId) },
        { helpId -> helpViewModel.getOneHelp(helpId) }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.helpViewModel = helpViewModel
        helpViewModel.getHelps()
        initBackBtnClickListener()
        initHelpRequestBtnClickListener()
        initHelpRvAdapter()
        initHelpListObserver()
        initOneHelpObserver()
        initIsSuccessPostHelpObserver()
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

    private fun moveHelpDoDialog(helpId: Int) {
        HelpDoDialogFragment().let {
            it.arguments = Bundle().apply { putInt("helpId", helpId) }
            it.show(supportFragmentManager, this.javaClass.name)
        }
    }

    private fun initOneHelpObserver() {
        helpViewModel.oneHelp.observe(this) { oneHelp ->
            if (oneHelp != null) {
                moveHelpDoDialog(helpViewModel.oneHelpId)
            }
        }
    }

    private fun initIsSuccessPostHelpObserver() {
        helpViewModel.isSuccessPostHelp.observe(this, EventObserver { isSuccess ->
            if (isSuccess) {
                helpViewModel.getHelps()
            }
        })
    }
}
