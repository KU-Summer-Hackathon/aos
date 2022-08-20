package com.yjooooo.doreandroid.presentation.message

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yjooooo.doreandroid.data.remote.entity.response.MessageRoom
import com.yjooooo.doreandroid.databinding.ItemMessageRoomBinding

class MessageRoomAdapter :
    ListAdapter<MessageRoom, MessageRoomAdapter.MessageRoomViewHolder>(messageRoomDiffUtil) {
    class MessageRoomViewHolder(
        private val binding: ItemMessageRoomBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(messageRoom: MessageRoom) {
            binding.messageRoom = messageRoom
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageRoomViewHolder =
        MessageRoomViewHolder(
            ItemMessageRoomBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MessageRoomViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val messageRoomDiffUtil = object : DiffUtil.ItemCallback<MessageRoom>() {
            override fun areItemsTheSame(
                oldItem: MessageRoom, newItem: MessageRoom
            ): Boolean =
                oldItem.chatId == newItem.chatId

            override fun areContentsTheSame(
                oldItem: MessageRoom, newItem: MessageRoom
            ): Boolean =
                oldItem == newItem

        }
    }
}
