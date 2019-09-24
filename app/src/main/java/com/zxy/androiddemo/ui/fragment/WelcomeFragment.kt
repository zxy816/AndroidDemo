package com.zxy.androiddemo.ui.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation

import com.zxy.androiddemo.R
import com.zxy.androiddemo.ui.base.BaseFragment
import com.zxy.androiddemo.viewmodel.fragment.WelcomeViewModel
import kotlinx.android.synthetic.main.fragment_welcome.*

class WelcomeFragment : BaseFragment() {

    companion object {
        fun newInstance() = WelcomeFragment()
    }

    private lateinit var viewModel: WelcomeViewModel

    override fun getLayout(): Int {
        return R.layout.fragment_welcome
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(WelcomeViewModel::class.java)
        button.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_welcomeFragment_to_loginFragment)
        }
    }
}
