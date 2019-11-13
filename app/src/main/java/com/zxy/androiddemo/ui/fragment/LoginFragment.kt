package com.zxy.androiddemo.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.zxy.androiddemo.R
import com.zxy.androiddemo.databinding.FragmentLoginBinding
import com.zxy.androiddemo.db.DbDataProvider
import com.zxy.androiddemo.db.business.UserSourceImpl
import com.zxy.androiddemo.ui.base.BaseFragment
import com.zxy.androiddemo.viewmodel.UserModel
import com.zxy.androiddemo.viewmodel.factory.UserModelFactory
import com.zxy.androiddemo.viewmodel.fragment.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : BaseFragment() {

    private lateinit var viewModel: LoginViewModel
    private lateinit var loginBinding: FragmentLoginBinding

    private lateinit var userSourceImpl: UserSourceImpl
    private lateinit var userModel:UserModel

    companion object {
        fun newInstance() = LoginFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userSourceImpl = DbDataProvider.provideUserDao(activity)
        userModel = ViewModelProviders.of(this, UserModelFactory(userSourceImpl)).get(UserModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        loginBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        return loginBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        mainActivity.setToolbar(isShow = false)
        setOnClickListener()
    }

    private fun setOnClickListener() {
        btn_login.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_pagingFragment)
        }
        btn_register.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_registFragment)
        }
        tv_forgetPwd.setOnClickListener {
            showToast("好好想下!")
        }
    }
}
