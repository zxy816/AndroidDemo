package com.zxy.androiddemo.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.zxy.androiddemo.R
import com.zxy.androiddemo.app.DemoApp
import com.zxy.androiddemo.db.Injection
import com.zxy.androiddemo.db.business.UserSourceImpl
import com.zxy.androiddemo.db.dao.UserDao
import com.zxy.androiddemo.db.entries.User

class MainActivity : AppCompatActivity() {

    private var userSourceImpl: UserSourceImpl? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userSourceImpl = Injection.provideUserDao(this)
        findUserBySex()
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
