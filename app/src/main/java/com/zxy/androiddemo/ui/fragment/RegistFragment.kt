package com.zxy.androiddemo.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.zxy.androiddemo.R
import com.zxy.androiddemo.databinding.FragmentRegistBinding
import com.zxy.androiddemo.db.RepositoryFactory
import com.zxy.androiddemo.ui.base.BaseFragment
import com.zxy.androiddemo.viewmodel.RegistViewModel
import kotlinx.android.synthetic.main.fragment_regist.*

class RegistFragment : BaseFragment() {
    private lateinit var viewModel: RegistViewModel
    private lateinit var registBinding: FragmentRegistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        registBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_regist, container, false)
        return registBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RegistViewModel::class.java)
        mainActivity.setToolbar(isShow = true, back = true, title = "注册")
        setOnClickListener()
    }

    private fun setOnClickListener() {
        btn_register.setOnClickListener {
            val userName = registBinding.etUserName.text.toString()
           viewModel.registerUserDB()
        }
    }
}
