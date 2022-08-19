package com.yjooooo.doreandroid.presentation.dore

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.yjooooo.doreandroid.R
import com.yjooooo.doreandroid.databinding.FragmentDoReBinding
import com.yjooooo.doreandroid.presentation.base.BaseFragment
import com.yjooooo.doreandroid.presentation.help.HelpActivity

class DoReFragment : BaseFragment<FragmentDoReBinding>(R.layout.fragment_do_re) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initHelpBtnClickListener()
    }

    private fun initHelpBtnClickListener() {
        binding.btnDoReHelp.setOnClickListener {
            startActivity(Intent(requireContext(), HelpActivity::class.java))
        }
    }
}
