package com.zxy.androiddemo.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.zxy.androiddemo.R
import com.zxy.androiddemo.databinding.FragmentRegistBinding
import com.zxy.androiddemo.ui.base.BaseFragment
import com.zxy.androiddemo.vm.RegistViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_regist.*

@AndroidEntryPoint
class RegistFragment : BaseFragment() {
    private val viewModel: RegistViewModel by viewModels()

    private lateinit var registBinding: FragmentRegistBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        registBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_regist, container, false)
        return registBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainActivity.setToolbar(isShow = true, back = true, title = "注册")
        setOnClickListener()
    }

    private fun setOnClickListener() {
        btn_register.setOnClickListener {
            val userName = registBinding.etUserName.text.toString()
//            viewModel.registerUserDB()
//            println("userName=$userName")
//            viewModel.translateWord(userName)
            viewModel.lotteryBet()
        }
        viewModel.translate.observe(viewLifecycleOwner) {
            println("=====界面返回的值为=$it")
        }
    }
}
