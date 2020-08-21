package com.zxy.androiddemo.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.zxy.androiddemo.R
import com.zxy.androiddemo.ui.base.BaseFragment
import com.zxy.androiddemo.vm.WelcomeViewModel
import kotlinx.android.synthetic.main.fragment_welcome.*

class WelcomeFragment : BaseFragment() {

    private lateinit var welcomeModel: WelcomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        welcomeModel = ViewModelProvider(this).get(WelcomeViewModel::class.java)
        mainActivity.setToolbar(isShow = false)
        clickListener()
    }

    private fun clickListener() {
        button.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_welcomeFragment_to_loginFragment)
        }
    }
}
