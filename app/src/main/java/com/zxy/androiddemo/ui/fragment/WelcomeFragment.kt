package com.zxy.androiddemo.ui.fragment

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.zxy.androiddemo.R
import com.zxy.androiddemo.ui.base.BaseFragment
import com.zxy.androiddemo.viewmodel.fragment.WelcomeViewModel
import kotlinx.android.synthetic.main.fragment_welcome.*

class WelcomeFragment : BaseFragment() {

    companion object {
        fun newInstance() = WelcomeFragment()
    }

    private lateinit var welcomeModel: WelcomeViewModel

    override fun getLayout(): Int {
        return R.layout.fragment_welcome
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        welcomeModel = ViewModelProviders.of(this).get(WelcomeViewModel::class.java)
        mainActivity.setToolbar(isShow = false)
        clickListener()
    }

    private fun clickListener() {
        button.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_welcomeFragment_to_loginFragment)
        }
    }
}
