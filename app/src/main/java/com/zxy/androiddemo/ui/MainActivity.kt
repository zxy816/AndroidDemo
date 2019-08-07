package com.zxy.androiddemo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zxy.androiddemo.R
import com.zxy.androiddemo.adapter.PagingAdapter
import com.zxy.androiddemo.db.Injection
import com.zxy.androiddemo.db.business.UserSourceImpl
import com.zxy.androiddemo.db.entries.Address
import com.zxy.androiddemo.db.entries.User
import com.zxy.androiddemo.paging.DataRepository
import com.zxy.androiddemo.paging.PagingDataSourceFactory

class MainActivity : AppCompatActivity() {

    private lateinit var userSourceImpl: UserSourceImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userSourceImpl = Injection.provideUserDao(this)
        userSourceImpl.getUsers()
//        insetTest()
        //paging test
        var adapter = PagingAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        val data = LivePagedListBuilder(PagingDataSourceFactory(DataRepository()), PagedList.Config.Builder()
                .setPageSize(20)
                .setInitialLoadSizeHint(20)
                .setEnablePlaceholders(true).build()).build()
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
