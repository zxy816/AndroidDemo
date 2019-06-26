package com.zxy.androiddemo

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.zxy.androiddemo.db.AppDatabase
import com.zxy.androiddemo.db.dao.UserDao
import com.zxy.androiddemo.db.entries.User
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    private var userDao:UserDao ?= null
    private var appDatabase:AppDatabase ?= null
    @Before
   fun createDB(){
       val context = InstrumentationRegistry.getTargetContext()
        appDatabase = Room.inMemoryDatabaseBuilder(context,AppDatabase::class.java).build()
        userDao = appDatabase?.userDao()
   }

    @After
    fun closeDB(){
        appDatabase?.close()
    }

    @Test
    fun testUserDao(){
        val user = User()
        user.userName = "zhangsan"
        user.pwd = "123123"
        user.sex = "女"
        user.age = 18
        user.phone = "18792430923"
        userDao?.inserUsers(user)
    }
}
