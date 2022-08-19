package com.yjooooo.doreandroid.presentation.ranking

import android.animation.Animator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yjooooo.doreandroid.R
import com.yjooooo.doreandroid.databinding.ItemRankingSurroundingBinding
import java.lang.IllegalStateException

class RankingSurroundingAdapter :
    ListAdapter<SurroundingData, RankingSurroundingAdapter.SurroundingViewHolder>(
        surroundingDiffUtil
    ) {
    class SurroundingViewHolder(
        private val binding: ItemRankingSurroundingBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(surrounding: SurroundingData) {
            when (surrounding.id % 4) {
                0, 3 -> binding.layoutRankingSurrounding.setBackgroundColor(
                    binding.root.context.getColor(
                        R.color.dore_yellow
                    )
                )
                else -> binding.layoutRankingSurrounding.setBackgroundColor(
                    binding.root.context.getColor(
                        R.color.dore_blue
                    )
                )
            }
            binding.surrounding = surrounding
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SurroundingViewHolder(
            ItemRankingSurroundingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(
        holder: SurroundingViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position))
    }

    companion object {
        private val surroundingDiffUtil = object : DiffUtil.ItemCallback<SurroundingData>() {
            override fun areItemsTheSame(
                oldItem: SurroundingData,
                newItem: SurroundingData
            ): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: SurroundingData,
                newItem: SurroundingData
            ): Boolean =
                oldItem == newItem

        }
    }
}
