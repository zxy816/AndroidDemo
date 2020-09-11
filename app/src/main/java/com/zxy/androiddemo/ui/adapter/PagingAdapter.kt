package com.zxy.androiddemo.ui.adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.zxy.androiddemo.bean.PagingBean

/**
 * @author: zxy
 * @date: 2018/7/12
 * @des:
 */
class PagingAdapter : PagingDataAdapter<PagingBean, PagingViewHolder>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagingViewHolder {
        return PagingViewHolder(parent)
    }

    override fun onBindViewHolder(holder: PagingViewHolder, position: Int) {
        getItem(position)?.let { holder.bindTo(it) }
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<PagingBean>() {

            override fun areItemsTheSame(oldItem: PagingBean, newItem: PagingBean): Boolean {
                return oldItem.id == newItem.id
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: PagingBean, newItem: PagingBean): Boolean {
                return newItem == oldItem
            }
        }
    }
}
