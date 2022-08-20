package com.yjooooo.doreandroid.presentation.message

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yjooooo.doreandroid.data.remote.entity.response.MessageRoom
import com.yjooooo.doreandroid.databinding.ItemMessageRoomBinding

class MessageRoomAdapter(
    private val moveMessageRoom: (MessageRoom) -> Unit
) :
    ListAdapter<MessageRoom, MessageRoomAdapter.MessageRoomViewHolder>(messageRoomDiffUtil) {
    class MessageRoomViewHolder(
        private val binding: ItemMessageRoomBinding,
        private val moveMessageRoom: (MessageRoom) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            initClickListener()
        }

        fun bind(messageRoom: MessageRoom) {
            binding.messageRoom = messageRoom
            binding.executePendingBindings()
        }

        private fun initClickListener() {
            binding.layoutMessageRoom.setOnClickListener {
                moveMessageRoom(requireNotNull(binding.messageRoom))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageRoomViewHolder =
        MessageRoomViewHolder(
            ItemMessageRoomBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            moveMessageRoom
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
