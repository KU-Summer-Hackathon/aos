package com.yjooooo.doreandroid.presentation.help

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yjooooo.doreandroid.data.remote.entity.response.Help
import com.yjooooo.doreandroid.databinding.ItemHelpBinding

class HelpAdapter : ListAdapter<Help, HelpAdapter.HelpViewHolder>(helpDiffUtil) {
    class HelpViewHolder(
        private val binding: ItemHelpBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(help: Help) {
            binding.help = help
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HelpViewHolder =
        HelpViewHolder(
            ItemHelpBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: HelpViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val helpDiffUtil = object : DiffUtil.ItemCallback<Help>() {
            override fun areItemsTheSame(
                oldItem: Help,
                newItem: Help
            ): Boolean =
                oldItem.helpId == newItem.helpId

            override fun areContentsTheSame(
                oldItem: Help,
                newItem: Help
            ): Boolean =
                oldItem == newItem

        }
    }
}
