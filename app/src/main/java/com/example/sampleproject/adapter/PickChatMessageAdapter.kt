package com.example.sampleproject.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.sampleproject.R
import com.example.sampleproject.data.PickChatMessage
import de.hdodenhof.circleimageview.CircleImageView

class PickChatMessageWrapper {
    var viewType: Int = 3
    var message: PickChatMessage? = null
    var middleMessage: String? = null
}

class PickChatMessageAdapter(mContext: Context, data: ArrayList<PickChatMessageWrapper>?) : BaseRecyclerViewAdapter<PickChatMessageWrapper, RecyclerView.ViewHolder>(mContext, data) {

    companion object {
        val LEFT_VIEWTYPE = 1
        val RIGHT_VIEWTYPE = 2
        val CONTEXT_VIEWTYPE = 3
        val MIDDLE_VIETYPE = 5
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == LEFT_VIEWTYPE) {
            return PickChatLeftViewHolder(parent)
        } else if (viewType == RIGHT_VIEWTYPE) {
            return PickChatRightViewHolder(parent)
        } else {
            return PickChatMiddleViewHolder(parent)
        }
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == LEFT_VIEWTYPE) {
            (viewHolder as PickChatLeftViewHolder).bind(position, mItems[position].message!!)
        } else if (getItemViewType(position) == RIGHT_VIEWTYPE) {
            (viewHolder as PickChatRightViewHolder).bind(position, mItems[position].message!!)
        } else {
            (viewHolder as PickChatMiddleViewHolder).bind(position, mItems[position].middleMessage)
        }
    }

    override fun getItemViewType(position: Int): Int {
        var wrapper = mItems[position]
        return wrapper.viewType
    }

    override fun add(item: PickChatMessageWrapper) {
        if (item.message != null) {
            addUserMessage(item.message!!)
        } else {
            super.add(item)
        }
    }

    fun addUserMessage(message: PickChatMessage) {
        var wrapper = PickChatMessageWrapper()
        if (message.chatType == PickChatMessageAdapter.LEFT_VIEWTYPE) {
            wrapper.viewType = PickChatMessageAdapter.LEFT_VIEWTYPE
        } else if (message.chatType == PickChatMessageAdapter.CONTEXT_VIEWTYPE) {
            wrapper.viewType = PickChatMessageAdapter.CONTEXT_VIEWTYPE
        } else {
            wrapper.viewType = PickChatMessageAdapter.RIGHT_VIEWTYPE
        }
        wrapper.message = message
        super.add(wrapper)
    }

    fun addMiddleMessage(message: String) {
        var wrapper = PickChatMessageWrapper()
        wrapper.viewType = PickChatMessageAdapter.MIDDLE_VIETYPE
        wrapper.middleMessage = message
        super.add(wrapper)
    }

    inner class PickChatLeftViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_chat_left, parent, false)) {
        private var imgvProfile: CircleImageView = itemView.findViewById(R.id.imgv_profile)
        private var txtvContent: TextView = itemView.findViewById(R.id.txtv_content)
        private var imgvContent: ImageView = itemView.findViewById(R.id.imgv_content)
        internal var txtvNickname: TextView = itemView.findViewById(R.id.txtv_nickname)

        fun bind(position: Int, chatMessage: PickChatMessage) {
            Glide.with(itemView).load(chatMessage.profileImage).into(imgvProfile)
            txtvNickname.text = chatMessage.userNickname
            if (position == 0) {
                txtvNickname.visibility = View.VISIBLE
                imgvProfile.visibility = View.VISIBLE
            } else if (getItemViewType(position - 1) == LEFT_VIEWTYPE) {
                txtvNickname.visibility = View.GONE
                imgvProfile.visibility = View.INVISIBLE
            } else {
                imgvProfile.visibility = View.VISIBLE
                txtvNickname.visibility = View.VISIBLE
            }
            if (!TextUtils.isEmpty(chatMessage.message)) {
                txtvContent.visibility = View.VISIBLE
                txtvContent.text = chatMessage.message
            } else {
                txtvContent.visibility = View.GONE
            }
            if (!TextUtils.isEmpty((chatMessage.imageURL))) {
                imgvContent.visibility = View.VISIBLE
                Glide.with(itemView).load(chatMessage.imageURL).into(imgvContent)
            } else {
                imgvContent.visibility = View.GONE
            }

        }
    }


    inner class PickChatRightViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_chat_right, parent, false)) {
        private var txtvContent: TextView = itemView.findViewById(R.id.txtv_content)
        private var imgvContent: ImageView = itemView.findViewById(R.id.imgv_content)
        private var txtvNickname: TextView = itemView.findViewById(R.id.txtv_nickname)

        fun bind(position: Int, chatMessage: PickChatMessage) {

            txtvNickname.text = itemView.context.getString(R.string.chat_another_user)
            if (position == 0) {
                txtvNickname.visibility = View.VISIBLE
            } else if (getItemViewType(position - 1) == RIGHT_VIEWTYPE) {
                txtvNickname.visibility = View.GONE
            } else {
                txtvNickname.visibility = View.VISIBLE
            }
            if (!TextUtils.isEmpty(chatMessage.message)) {
                txtvContent.visibility = View.VISIBLE
                txtvContent.text = chatMessage.message
            } else {
                txtvContent.visibility = View.GONE
            }
            if (!TextUtils.isEmpty((chatMessage.imageURL))) {
                imgvContent.visibility = View.VISIBLE
                Glide.with(itemView).load(chatMessage.imageURL).into(imgvContent)
            } else {
                imgvContent.visibility = View.GONE
            }
        }
    }


    inner class PickChatMiddleViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_chat_header_pick, parent, false)) {
        private var txtvHeader: TextView = itemView.findViewById(R.id.txtv_header)
        fun bind(position: Int, chatMessage: String?) {
            if (!TextUtils.isEmpty(chatMessage)) {
                txtvHeader.text = chatMessage
                txtvHeader.visibility = View.VISIBLE
            } else {
                txtvHeader.visibility = View.GONE
            }
        }
    }
}
