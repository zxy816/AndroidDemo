package com.zxy.androiddemo.ui.my

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.zxy.androiddemo.databinding.FragmentRegistBinding
import com.zxy.androiddemo.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegistFragment : BaseFragment() {
    private val viewModel: RegistViewModel by viewModels()

    private lateinit var _binding: FragmentRegistBinding
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentRegistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.btnRegister.setOnClickListener {
            val userName = binding.etUserName.text.toString()
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
