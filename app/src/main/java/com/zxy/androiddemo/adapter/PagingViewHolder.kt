package com.zxy.androiddemo.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.zxy.androiddemo.R
import com.zxy.androiddemo.bean.PagBean

/**
 * @author: zxy
 * @date: 2018/7/12
 * @des:
 */
class PagingViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_paging_recyclerview, parent, false)
) {
    private val nameView = itemView.findViewById<TextView>(R.id.name)
    private val codeView = itemView.findViewById<TextView>(R.id.code)
    var pagBean: PagBean? = null

    fun bindTo(pagBean: PagBean?) {
        this.pagBean = pagBean
        nameView.text = pagBean?.name
        codeView.text = "${pagBean?.code}"
    }
}
