package com.zxy.androiddemo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zxy.androiddemo.R
import com.zxy.androiddemo.adapter.PagingAdapter
import com.zxy.androiddemo.db.DbDataProvider
import com.zxy.androiddemo.db.business.UserSourceImpl
import com.zxy.androiddemo.db.entries.Address
import com.zxy.androiddemo.db.entries.User
import com.zxy.androiddemo.viewmodel.UserModel
import com.zxy.androiddemo.viewmodel.factory.UserModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var userSourceImpl: UserSourceImpl

    private lateinit var userModel:UserModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userSourceImpl = DbDataProvider.provideUserDao(this)
        userModel = ViewModelProviders.of(this,UserModelFactory(userSourceImpl)).get(UserModel::class.java)
//        insetTest()
        //paging testls
        var adapter = PagingAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

//        userModel.users.observe(this, Observer{
//            adapter.submitList(it)
//        })
        userModel.users.observe(this, Observer {
            adapter.submitList(it)
        })
    }

    fun insetTest() {
        for (i in 1..50){
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
