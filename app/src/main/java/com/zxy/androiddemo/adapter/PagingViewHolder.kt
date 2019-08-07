package com.zxy.androiddemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zxy.androiddemo.R
import com.zxy.androiddemo.db.entries.User

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
    var user: User? = null

    fun bindTo(user: User?) {
        this.user = user
        nameView.text = user?.userName
        codeView.text = user?.address?.province
    }
}
