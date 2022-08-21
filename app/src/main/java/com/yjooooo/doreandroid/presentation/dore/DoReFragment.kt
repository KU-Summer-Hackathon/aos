package com.yjooooo.doreandroid.presentation.dore

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.yjooooo.doreandroid.R
import com.yjooooo.doreandroid.databinding.FragmentDoReBinding
import com.yjooooo.doreandroid.presentation.base.BaseFragment
import com.yjooooo.doreandroid.presentation.eat.EatActivity
import com.yjooooo.doreandroid.presentation.help.HelpActivity
import com.yjooooo.doreandroid.presentation.message.MessageActivity

class DoReFragment : BaseFragment<FragmentDoReBinding>(R.layout.fragment_do_re) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMessageBtnClickListener()
        initHelpBtnClickListener()
        initEatBtnClickListener()
    }

    private fun initMessageBtnClickListener() {
        binding.btnDoReMessage.setOnClickListener {
            startActivity(Intent(requireContext(), MessageActivity::class.java))
        }
    }

    private fun initHelpBtnClickListener() {
        binding.btnDoReHelp.setOnClickListener {
            startActivity(Intent(requireContext(), HelpActivity::class.java))
        }
    }

    private fun initEatBtnClickListener() {
        binding.btnDoReEat.setOnClickListener {
            startActivity(Intent(requireContext(), EatActivity::class.java))
        }
    }
}
