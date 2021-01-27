package com.zxy.androiddemo.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.zxy.androiddemo.R
import com.zxy.androiddemo.databinding.FragmentWelcomeBinding
import com.zxy.androiddemo.ui.base.BaseFragment
import com.zxy.androiddemo.vm.WelcomeViewModel

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
        mainActivity.setToolbar(isShow = false)
        clickListener()
    }

    private fun clickListener() {
        binding.button.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_welcomeFragment_to_loginFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
