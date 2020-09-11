package com.zxy.androiddemo.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zxy.androiddemo.R
import com.zxy.androiddemo.bean.PagingBean

/**
 * @author: zxy
 * @date: 2018/7/12
 * @des:
 */
class PagingViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_paging_recyclerview, parent, false)
) {
    private val nameView = itemView.findViewById<TextView>(R.id.name)
    private val sexView = itemView.findViewById<TextView>(R.id.sex)
    var pagingBean: PagingBean? = null

    fun bindTo(pagingBean: PagingBean) {
        this.pagingBean = pagingBean
        nameView.text = pagingBean.accountOrderId
        sexView.text = pagingBean.betMoney
    }
}
