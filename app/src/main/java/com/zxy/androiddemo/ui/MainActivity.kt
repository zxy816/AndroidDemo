package com.zxy.androiddemo.ui

import android.arch.lifecycle.Observer
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.zxy.androiddemo.R
import com.zxy.androiddemo.adapter.PagingAdapter
import com.zxy.androiddemo.db.Injection
import com.zxy.androiddemo.db.business.UserSourceImpl
import com.zxy.androiddemo.db.entries.User
import com.zxy.androiddemo.paging.DataRepository
import com.zxy.androiddemo.paging.PagingDataSourceFactory

class MainActivity : AppCompatActivity() {

    private var userSourceImpl: UserSourceImpl? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userSourceImpl = Injection.provideUserDao(this)
        findUserBySex()

        //paging test
        var adapter = PagingAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        val data = LivePagedListBuilder(PagingDataSourceFactory(DataRepository()),PagedList.Config.Builder()
                .setPageSize(20)
                .setInitialLoadSizeHint(20)
                .setEnablePlaceholders(true).build()).build()

        data.observe(this, Observer {
            adapter.submitList(it)
        })
    }

    fun insetTest() {
        val user = User()
        user.userName = "admin"
        user.pwd = "123456"
        user.sex = "男"
        user.age = 22
        user.phone = "18792430923"
        userSourceImpl!!.insertUser(user)
    }

    fun findUserBySex() {
        val list = userSourceImpl!!.getUsersBySex("男")
        if (list != null && list.size > 0) {
            for (i in list.indices) {
                println(list[i].toString())
            }
        } else {
            println("--------null---------")
        }
    }
}
