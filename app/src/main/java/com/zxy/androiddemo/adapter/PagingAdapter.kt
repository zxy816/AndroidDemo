package com.zxy.androiddemo.adapter

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.zxy.androiddemo.db.entries.User

/**
 * @author: zxy
 * @date: 2018/7/12
 * @des:
 */
class PagingAdapter : PagingDataAdapter<User, PagingViewHolder>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagingViewHolder {
        return PagingViewHolder(parent)
    }

    override fun onBindViewHolder(holder: PagingViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<User>() {

            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.uid == newItem.uid
            }

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                return newItem == oldItem
            }
        }
    }
}
