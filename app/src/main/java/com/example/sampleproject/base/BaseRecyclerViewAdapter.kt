package com.example.sampleproject.base

import android.content.Context
import android.support.v7.widget.RecyclerView

abstract class BaseRecyclerViewAdapter<T, VH : RecyclerView.ViewHolder>(context: Context, mItems: ArrayList<T>?) :
    RecyclerView.Adapter<VH>() {

    protected val context = context
    protected var mItems = mItems ?: ArrayList()

    val items: ArrayList<T>
        get() = mItems

    open fun add(item: T) {
        val position = itemCount
        mItems.add(item)
        notifyItemInserted(position)
    }

    open fun add(item: T, index: Int) {
        mItems.add(index, item)
        notifyItemInserted(index)
    }

    open fun add(items: ArrayList<T>?) {
        if (items != null && items.size > 0) {
            val position = itemCount
            mItems.addAll(items)
            notifyItemRangeInserted(position, items.size)
        }
    }

    open fun remove(position: Int) {
        if (position < itemCount) {
            mItems.removeAt(position)
            notifyDataSetChanged()
        }
    }

    open fun remove(item: T) {
        val position = mItems.indexOf(item)
        remove(position)
    }

    open fun clear() {
        val count = mItems.size
        if (count > 0) {
            mItems.clear()
            notifyDataSetChanged()
        }
    }

    open fun update(position: Int, item: T) {
        if (position < itemCount) {
            mItems[position] = item
            notifyItemChanged(position, item)
        }
    }


    open fun update(data: ArrayList<T>?) {
        if (data == null || data.isEmpty()) {
            mItems.clear()
            notifyDataSetChanged()
        } else {
            mItems.clear()
            mItems.addAll(data)
            notifyDataSetChanged()
        }
    }

    override fun getItemId(position: Int): Long {
        return if (position < itemCount) {
            mItems[position].hashCode().toLong()
        } else super.getItemId(position)
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    open fun getItem(position: Int): T {
        return mItems[position]
    }
}