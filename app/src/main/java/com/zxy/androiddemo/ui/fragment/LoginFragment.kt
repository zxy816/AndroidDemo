package com.zxy.androiddemo.ui.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation

import com.zxy.androiddemo.R
import com.zxy.androiddemo.ui.base.BaseFragment
import com.zxy.androiddemo.viewmodel.fragment.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : BaseFragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel

    override fun getLayout(): Int {
        return R.layout.fragment_login
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        setOnClickListener()
    }

    private fun setOnClickListener() {
        btn_login.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_pagingFragment)
        }
    }
}
