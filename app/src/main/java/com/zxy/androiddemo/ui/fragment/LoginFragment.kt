package com.zxy.androiddemo.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.zxy.androiddemo.R
import com.zxy.androiddemo.ui.base.BaseFragment
import com.zxy.androiddemo.viewmodel.fragment.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : BaseFragment() {

    private lateinit var viewModel: LoginViewModel

    companion object {
        fun newInstance() = LoginFragment()
    }

    override fun getLayout(): Int {
        return R.layout.fragment_login
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        mainActivity.setToolbar(isShow = true, title = "登录")
        setOnClickListener()
    }

    private fun setOnClickListener() {
        btn_login.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_pagingFragment)
        }
    }
}
