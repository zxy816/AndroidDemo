package com.zxy.androiddemo.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.zxy.androiddemo.R
import com.zxy.androiddemo.databinding.FragmentPagingBinding
import com.zxy.androiddemo.ui.adapter.PagingAdapter
import com.zxy.androiddemo.ui.base.BaseFragment
import com.zxy.androiddemo.vm.PagingViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_paging.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PagingFragment : BaseFragment() {

    private val viewModel: PagingViewModel by viewModels()
    private lateinit var pagingBinding: FragmentPagingBinding
    private val adapter by lazy { PagingAdapter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        pagingBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_paging, container, false)
        return pagingBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainActivity.setToolbar(isShow = true, back = true, title = "分页")
        //paging test
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        lifecycleScope.launch {
            @OptIn(ExperimentalCoroutinesApi::class)
            viewModel.getUsers.collectLatest {
                adapter.submitData(it)
            }
        }
    }
}
