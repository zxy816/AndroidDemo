package com.zxy.androiddemo.ui.my

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.zxy.androiddemo.R
import com.zxy.androiddemo.databinding.FragmentLoginBinding
import com.zxy.androiddemo.ui.base.BaseFragment

class LoginFragment : BaseFragment() {

    private lateinit var viewModel: LoginViewModel
    private lateinit var _binding: FragmentLoginBinding
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        setOnClickListener()
    }

    private fun setOnClickListener() {

    }
}
