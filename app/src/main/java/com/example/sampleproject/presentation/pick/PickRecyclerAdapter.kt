package com.example.sampleproject.presentation.pick

import android.content.Context
import android.support.v4.view.AsyncLayoutInflater
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.example.sampleproject.R
import com.example.sampleproject.domain.CuratingContents
import kotlinx.android.synthetic.main.item_curating_contents.view.*
import java.util.*
import kotlin.collections.ArrayList

class PickRecylcerAdapter(var context: Context, val listener: OnPickItemClickListener?) : ListAdapter<CuratingContents, PickRecylcerAdapter.PickViewHolder>(MyDiffCallback()) {

    var data = ArrayList<CuratingContents>()

    companion object {
        const val NUM_CACHED_VIEWS = 5
    }

    private val asyncLayoutInflater = AsyncLayoutInflater(context)
    private val cachedViews = Stack<View>()

    init {
        for (i in 0..NUM_CACHED_VIEWS) {
            asyncLayoutInflater.inflate(R.layout.item_curating_contents, null) { view, layoutRes, viewGroup ->
                cachedViews.push(view)
            }
        }
    }

    interface OnPickItemClickListener {
        fun onPickItemClicked(contentsId: Int)
    }

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PickViewHolder {
        val view = if (cachedViews.isEmpty()) {
            LayoutInflater.from(context).inflate(R.layout.item_curating_contents, parent, false)
        } else {
            cachedViews.pop().also {
                it.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            }
        }
        return PickViewHolder(view)
    }

    override fun onBindViewHolder(holder: PickViewHolder, position: Int) {
        holder.bindTo(data[position])
    }

    fun addMoreData(curatingContents: CuratingContents) {
        data.add(curatingContents)
        notifyDataSetChanged()
    }

    fun addMoreDatas(curatingContents: ArrayList<CuratingContents>) {
        data.addAll(curatingContents)
        notifyDataSetChanged()
    }

    inner class PickViewHolder(view: View) : RecyclerView.ViewHolder(view) {

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

    class MyDiffCallback : DiffUtil.ItemCallback<CuratingContents>() {
        override fun areItemsTheSame(firstItem: CuratingContents, secondItem: CuratingContents) = firstItem.id == secondItem.id

        override fun areContentsTheSame(firstItem: CuratingContents, secondItem: CuratingContents) = firstItem.equals(secondItem)
    }


}
