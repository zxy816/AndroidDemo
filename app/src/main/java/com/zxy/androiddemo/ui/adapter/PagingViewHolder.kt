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
    private val nameText = itemView.findViewById<TextView>(R.id.tv_name)
    private val descText = itemView.findViewById<TextView>(R.id.tv_description)
    private val starText = itemView.findViewById<TextView>(R.id.tv_star_count)
    var pagingBean: PagingBean? = null

    fun bindTo(pagingBean: PagingBean) {
        this.pagingBean = pagingBean
        nameText.text = pagingBean.name
        descText.text = pagingBean.description
        starText.text = pagingBean.starCount.toString()
    }
}
