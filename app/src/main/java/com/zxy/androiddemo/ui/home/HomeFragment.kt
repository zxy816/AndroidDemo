package com.zxy.androiddemo.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zxy.androiddemo.databinding.FragmentPagingBinding
import com.zxy.androiddemo.ui.base.BaseFragment

class HomeFragment : BaseFragment() {

    private lateinit var _binding: FragmentPagingBinding
    private val binding get() = _binding
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentPagingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
    }
}