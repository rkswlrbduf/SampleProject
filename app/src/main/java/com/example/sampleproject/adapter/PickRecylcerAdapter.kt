package com.example.sampleproject.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.sampleproject.R
import com.example.sampleproject.data.CuratingContents

/*

class PickRecylcerAdapter(context: Context, data: ArrayList<CuratingContents>, val listener: OnPickItemClickListener?) : BaseRecyclerViewAdapter<CuratingContents, RecyclerView.ViewHolder>(context, data) {

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


    inner class PickViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_curaing_contents, parent, false)) {

        var contentsId = itemView.findViewById<TextView>(R.id.curating_contents_id)
        var img = itemView.findViewById<ImageView>(R.id.curating_contents_image)
        var title = itemView.findViewById<TextView>(R.id.curating_contents_title)
        var author = itemView.findViewById<ImageView>(R.id.curating_contents_author_profile_image)
        var nickname = itemView.findViewById<TextView>(R.id.curating_contents_author_nickname)
        var like = itemView.findViewById<TextView>(R.id.curating_contents_like_count)
        var viewCount = itemView.findViewById<TextView>(R.id.curating_contents_view_count)

        fun bindTo(contents: CuratingContents?) {
            if (contents == null) return
            contentsId.text = contents.id.toString()
            title.text = contents.title
            nickname.text = contents.teacherNickName
            like.text = contents.likeCount.toString()
            GlideApp.with(itemView).load(contents.thumbnail).thumbnail(0.1f).into(img)
            GlideApp.with(itemView).load(createImageUrl(contents.profileImageKey)).thumbnail(0.1f).into(author)
            viewCount.text = contents.viewCount.toString()

            itemView.setOnClickListener {
                listener?.onPickItemClicked(contents.id)
            }

        }

    }


}*/
