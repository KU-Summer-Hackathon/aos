package com.yjooooo.doreandroid.presentation.ranking

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.yjooooo.doreandroid.R
import com.yjooooo.doreandroid.databinding.FragmentRankingBinding
import com.yjooooo.doreandroid.presentation.base.BaseFragment

class RankingFragment : BaseFragment<FragmentRankingBinding>(R.layout.fragment_ranking) {
    private val rankingVieWModel by viewModels<RankingViewModel>()
    private val rankingSurroundingAdapter = RankingSurroundingAdapter()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSurroundingRvAdapter()
    }

    private fun initSurroundingRvAdapter() {
        binding.rvRankingSurrounding.adapter = rankingSurroundingAdapter
        rankingSurroundingAdapter.submitList(rankingVieWModel.surroundingList)

    }
}
