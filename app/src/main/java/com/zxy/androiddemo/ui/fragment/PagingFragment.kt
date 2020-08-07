package com.zxy.androiddemo.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.zxy.androiddemo.R
import com.zxy.androiddemo.adapter.PagingAdapter
import com.zxy.androiddemo.databinding.FragmentPagingBinding
import com.zxy.androiddemo.ui.base.BaseFragment
import com.zxy.androiddemo.viewmodel.PagingViewModel
import kotlinx.android.synthetic.main.fragment_paging.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PagingFragment : BaseFragment() {

    private val viewModel : PagingViewModel by activityViewModels()
    private lateinit var pagingBinding: FragmentPagingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        pagingBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_paging, container, false)
        return pagingBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mainActivity.setToolbar(isShow = true, back = true, title = "分页")
        //paging test
        var adapter = PagingAdapter()
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter

        viewModel.getUsers.observe(viewLifecycleOwner, Observer { data ->
            adapter.submitData(lifecycle, data)
        })
    }
}
