package com.zxy.androiddemo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.zxy.androiddemo.R
import com.zxy.androiddemo.databinding.FragmentWelcomeBinding
import com.zxy.androiddemo.ui.base.BaseFragment

class WelcomeFragment : BaseFragment() {

    private lateinit var welcomeModel: WelcomeViewModel
    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        welcomeModel = ViewModelProvider(this).get(WelcomeViewModel::class.java)
        clickListener()
    }

    private fun clickListener() {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
