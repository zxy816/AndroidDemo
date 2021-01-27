package com.zxy.androiddemo.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.zxy.androiddemo.R
import com.zxy.androiddemo.databinding.FragmentLoginBinding
import com.zxy.androiddemo.ui.base.BaseFragment
import com.zxy.androiddemo.vm.LoginViewModel

class LoginFragment : BaseFragment() {

    private lateinit var viewModel: LoginViewModel
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        mainActivity.setToolbar(isShow = false)
        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.btnLogin.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_pagingFragment)
        }
        binding.btnRegister.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_registFragment)
        }
        binding.tvForgetPwd.setOnClickListener {
            showToast("好好想下!")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
