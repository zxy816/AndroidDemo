package com.zxy.androiddemo.ui.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.zxy.androiddemo.R
import com.zxy.androiddemo.databinding.FragmentRegistBinding
import com.zxy.androiddemo.ui.base.BaseFragment
import com.zxy.androiddemo.viewmodel.fragment.RegistViewModel

class RegistFragment : BaseFragment() {

    companion object {
        fun newInstance() = RegistFragment()
    }

    private lateinit var viewModel: RegistViewModel
    private lateinit var registBinding: FragmentRegistBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        registBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_regist,container,false)
        return registBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RegistViewModel::class.java)
    }

}
