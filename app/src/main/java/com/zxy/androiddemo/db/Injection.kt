package com.zxy.androiddemo.db

import android.content.Context

import com.zxy.androiddemo.db.business.UserSourceImpl
import com.zxy.androiddemo.db.dao.UserDao

/**
 * @author: zxy
 * @date: 2018/7/11
 * @des:
 */
object Injection {
    fun provideUserDao(context: Context): UserSourceImpl {
        val appDatabase = AppDatabase.getInstance(context)
        val userDao = appDatabase!!.userDao()
        return UserSourceImpl(userDao)
    }
}
