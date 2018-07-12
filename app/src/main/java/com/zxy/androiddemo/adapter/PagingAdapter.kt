package com.zxy.androiddemo.adapter

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.view.ViewGroup
import com.zxy.androiddemo.bean.PagBean

/**
 * @author: zxy
 * @date: 2018/7/12
 * @des:
 */
class PagingAdapter : PagedListAdapter<PagBean, PagingViewHolder>(callback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagingViewHolder {
        return PagingViewHolder(parent)
    }

    override fun onBindViewHolder(holder: PagingViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    companion object {
        var callback = object : DiffUtil.ItemCallback<PagBean>() {

            override fun areItemsTheSame(oldItem: PagBean, newItem: PagBean): Boolean {
                return oldItem.code == newItem.code
            }

            override fun areContentsTheSame(oldItem: PagBean, newItem: PagBean): Boolean {
                return oldItem === newItem
            }
        }
    }
}
