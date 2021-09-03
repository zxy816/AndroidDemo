package com.zxy.androiddemo.ui.paging

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.zxy.androiddemo.databinding.FragmentPagingBinding
import com.zxy.androiddemo.ui.adapter.PagingAdapter
import com.zxy.androiddemo.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PagingFragment : BaseFragment() {

    private val viewModel: PagingViewModel by viewModels()
    private var _binding: FragmentPagingBinding? = null
    private val binding get() = _binding!!
    private val adapter by lazy { PagingAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPagingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //paging test
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.adapter = adapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        lifecycleScope.launch {
            viewModel.getHubAndroid.collectLatest {
                adapter.submitData(it)
            }
        }
        adapter.addLoadStateListener {
            when (it.refresh) {
                is LoadState.NotLoading -> {
                    binding.swipeRefresh.visibility = View.INVISIBLE
                }
                is LoadState.Loading -> {
                    binding.swipeRefresh.visibility = View.VISIBLE
                }
                is LoadState.Error -> {
                    binding.swipeRefresh.visibility = View.INVISIBLE
                    val state = it.refresh as LoadState.Error
                    showToast("加载错误:$state")
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
