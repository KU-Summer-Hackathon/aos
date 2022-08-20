package com.yjooooo.doreandroid.presentation.message_room

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yjooooo.doreandroid.data.local.MessageType.Companion.ACCEPTED_HELP
import com.yjooooo.doreandroid.data.local.MessageType.Companion.ACCEPT_HELP
import com.yjooooo.doreandroid.data.local.MessageType.Companion.CHECK_HELP
import com.yjooooo.doreandroid.data.local.MessageType.Companion.COMPLETE_HELP
import com.yjooooo.doreandroid.data.local.MessageType.Companion.PENDING_HELP
import com.yjooooo.doreandroid.data.local.MessageType.Companion.PENDING_MISSION
import com.yjooooo.doreandroid.data.local.MessageType.Companion.REQUEST_HELP
import com.yjooooo.doreandroid.data.remote.entity.response.Message
import com.yjooooo.doreandroid.databinding.ItemMessageCheckHelpBinding
import com.yjooooo.doreandroid.databinding.ItemMessageCompleteHelpBinding
import com.yjooooo.doreandroid.databinding.ItemMessageHelpBinding
import com.yjooooo.doreandroid.databinding.ItemMessageMissionBinding
import java.lang.IllegalStateException

class MessageAdapter :
    ListAdapter<Message, RecyclerView.ViewHolder>(messageDiffUtil) {
    class MessageHelpViewHolder(private val binding: ItemMessageHelpBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(message: Message) {
            binding.msgHelp = message
            binding.executePendingBindings()
        }
    }

    class MessageCheckHelpViewHolder(private val binding: ItemMessageCheckHelpBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(message: Message) {
            binding.msgCheckHelp = message
            binding.executePendingBindings()
        }
    }

    class MessageMissionViewHolder(private val binding: ItemMessageMissionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(message: Message) {
            binding.msgMission = message
            binding.executePendingBindings()
        }
    }

    class MessageCompleteHelpViewHolder(binding: ItemMessageCompleteHelpBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            REQUEST_HELP, ACCEPT_HELP, ACCEPTED_HELP, PENDING_HELP ->
                MessageHelpViewHolder(
                    ItemMessageHelpBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            CHECK_HELP -> MessageCheckHelpViewHolder(
                ItemMessageCheckHelpBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            COMPLETE_HELP -> MessageCompleteHelpViewHolder(
                ItemMessageCompleteHelpBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            PENDING_MISSION -> MessageMissionViewHolder(
                ItemMessageMissionBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> throw IllegalStateException("메시지 뷰타입 설정 오류")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MessageHelpViewHolder -> holder.bind(getItem(position))
            is MessageCheckHelpViewHolder -> holder.bind(getItem(position))
            is MessageMissionViewHolder -> holder.bind(getItem(position))
        }
    }

    override fun getItemViewType(position: Int) = getItem(position).type

    companion object {
        private val messageDiffUtil = object : DiffUtil.ItemCallback<Message>() {
            override fun areItemsTheSame(
                oldItem: Message, newItem: Message
            ): Boolean =
                oldItem.messageId == newItem.messageId

            override fun areContentsTheSame(
                oldItem: Message, newItem: Message
            ): Boolean =
                oldItem == newItem

        }
    }

}
