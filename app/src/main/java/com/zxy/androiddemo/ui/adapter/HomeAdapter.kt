package com.zxy.androiddemo.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zxy.androiddemo.databinding.ItemHomeBinding
import java.util.*

class HomeAdapter<T>(var context: Context, var list: List<String>) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    init {
        if (list == null) {
            list = ArrayList()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding);
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.binding.itemTitle.text = list[position]

    }

    override fun getItemCount(): Int = list.size

    class HomeViewHolder(var binding: ItemHomeBinding) : RecyclerView.ViewHolder(binding.root)
}