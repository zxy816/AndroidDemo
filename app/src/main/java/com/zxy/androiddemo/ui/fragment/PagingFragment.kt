package com.zxy.androiddemo.ui.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.zxy.androiddemo.R
import com.zxy.androiddemo.adapter.PagingAdapter
import com.zxy.androiddemo.databinding.FragmentLoginBinding
import com.zxy.androiddemo.databinding.FragmentPagingBinding
import com.zxy.androiddemo.db.DbDataProvider
import com.zxy.androiddemo.db.business.UserSourceImpl
import com.zxy.androiddemo.db.entries.Address
import com.zxy.androiddemo.db.entries.User
import com.zxy.androiddemo.ui.base.BaseFragment
import com.zxy.androiddemo.viewmodel.UserModel
import com.zxy.androiddemo.viewmodel.factory.UserModelFactory
import com.zxy.androiddemo.viewmodel.fragment.PagingViewModel
import kotlinx.android.synthetic.main.fragment_paging.*

class PagingFragment : BaseFragment() {
    companion object {
        fun newInstance() = PagingFragment()
    }

    private lateinit var userSourceImpl: UserSourceImpl

    private lateinit var viewModel: PagingViewModel
    private lateinit var userModel: UserModel
    private lateinit var pagingBinding: FragmentPagingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userSourceImpl = DbDataProvider.provideUserDao(activity)
        userModel = ViewModelProviders.of(this, UserModelFactory(userSourceImpl)).get(UserModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        pagingBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_paging, container, false)
        return pagingBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PagingViewModel::class.java)
        mainActivity.setToolbar(isShow = true, back = true, title = "分页")
//        insetTest()
        //paging test
        var adapter = PagingAdapter()
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter

        userModel.users.observe(this, Observer {
            adapter.submitList(it)
        })
    }

    fun insetTest() {
        for (i in 1..50) {
            val user = User()
            user.userName = "张 -- $i"
            user.pwd = "123456"
            user.sex = if (i % 2 == 0) "男" else "女"
            user.age = 22
            user.phone = "18792430923"
            val address = Address()
            address.province = "陕西省"
            address.city = "西安市"
            address.county = "雁塔区"
            address.street = "电子城街道"
            user.address = address
            userSourceImpl?.insertUser(user)
        }
    }
}
