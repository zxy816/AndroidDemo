package com.zxy.androiddemo.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.zxy.androiddemo.R
import com.zxy.androiddemo.databinding.FragmentRegistBinding
import com.zxy.androiddemo.db.DbDataProvider
import com.zxy.androiddemo.db.business.UserSourceImpl
import com.zxy.androiddemo.db.entries.Address
import com.zxy.androiddemo.db.entries.User
import com.zxy.androiddemo.ui.base.BaseFragment
import com.zxy.androiddemo.viewmodel.UserModel
import com.zxy.androiddemo.viewmodel.factory.UserModelFactory
import com.zxy.androiddemo.viewmodel.fragment.RegistViewModel
import kotlinx.android.synthetic.main.fragment_regist.*

class RegistFragment : BaseFragment() {

    companion object {
        fun newInstance() = RegistFragment()
    }

    private lateinit var userSourceImpl: UserSourceImpl

    private lateinit var viewModel: RegistViewModel
    private lateinit var registBinding: FragmentRegistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userSourceImpl = DbDataProvider.provideUserDao(activity)
//        userModel = ViewModelProviders.of(this, UserModelFactory(userSourceImpl)).get(UserModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        registBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_regist, container, false)
        return registBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RegistViewModel::class.java)
        mainActivity.setToolbar(isShow = true, back = true, title = "注册")
        btn_register.setOnClickListener {
            val user = User()
            user.userName = "zxy"
            user.pwd = "123456"
            user.sex = "男"
            user.age = 30
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
