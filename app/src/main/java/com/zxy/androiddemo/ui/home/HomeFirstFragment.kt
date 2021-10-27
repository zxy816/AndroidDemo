package com.zxy.androiddemo.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.zxy.androiddemo.R

class HomeFirstFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()

    companion object {
        @JvmStatic
        fun newInstance() = HomeFirstFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_first, container, false)
    }

    private fun loadData() {
        viewModel.homeApi("zxy").observe(viewLifecycleOwner, {
            println(Thread.currentThread().name + "=======$it")
        })
    }
}