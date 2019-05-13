package com.example.sampleproject.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.sampleproject.R
import com.example.sampleproject.data.CuratingContents
import kotlinx.android.synthetic.main.item_curating_contents.view.*

class PickRecylcerAdapter(context: Context, data: ArrayList<CuratingContents>?, val listener: OnPickItemClickListener?) : BaseRecyclerViewAdapter<CuratingContents, RecyclerView.ViewHolder>(context, data) {

    interface OnPickItemClickListener {
        fun onPickItemClicked(contentsId: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = PickViewHolder(parent)


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //holder.bindTo(contentsList?.get(position)!!)
        mItems?.get(position).let {
            (holder as PickViewHolder).bindTo(it)
        }
    }


    inner class PickViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_curating_contents, parent, false)) {

        private var contentsId = itemView.curating_contents_id
        private var img = itemView.curating_contents_image
        private var title = itemView.curating_contents_title
        private var author = itemView.curating_contents_author_profile_image
        private var nickname = itemView.curating_contents_author_nickname
        private var like = itemView.curating_contents_like_count
        private var viewCount = itemView.curating_contents_view_count

        fun bindTo(contents: CuratingContents?) {
            if (contents == null) return
            contentsId.text = contents.id.toString()
            title.text = contents.title
            nickname.text = contents.teacherNickName
            like.text = contents.likeCount.toString()
            Glide.with(itemView).load(contents.thumbnail).thumbnail(0.1f).into(img)
            Glide.with(itemView).load(contents.profileImageKey).thumbnail(0.1f).into(author)
            viewCount.text = contents.viewCount.toString()

            itemView.setOnClickListener {
                listener?.onPickItemClicked(contents.id)
            }

        }

    }


}
