package com.zxy.androiddemo.ui.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.zxy.androiddemo.R
import com.zxy.androiddemo.viewmodel.fragment.PagingViewModel

class PagingFragment : Fragment() {

    companion object {
        fun newInstance() = PagingFragment()
    }

    private lateinit var viewModel: PagingViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_paging, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PagingViewModel::class.java)

    }

}
