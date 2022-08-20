package com.yjooooo.doreandroid.presentation.profile

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.yjooooo.doreandroid.R
import com.yjooooo.doreandroid.databinding.FragmentProfileBinding
import com.yjooooo.doreandroid.presentation.base.BaseFragment
import com.yjooooo.doreandroid.presentation.lamp.LampActivity

class ProfileFragment : BaseFragment<FragmentProfileBinding>(R.layout.fragment_profile) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBuyLampBtnClickListener()
    }

    private fun initBuyLampBtnClickListener() {
        binding.btnProfileBuyLamp.setOnClickListener {
            startActivity(Intent(requireContext(), LampActivity::class.java))
        }
    }
}
