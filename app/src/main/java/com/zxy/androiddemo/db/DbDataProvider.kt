package com.zxy.androiddemo.db

import android.content.Context

import com.zxy.androiddemo.db.business.UserSourceImpl
import com.zxy.androiddemo.db.dao.UserDao

object DbDataProvider {
    fun provideUserDao(context: Context?): UserSourceImpl {
        val appDatabase = AppDatabase.getInstance(context)
        val userDao = appDatabase!!.userDao()
        return UserSourceImpl(userDao)
    }
}
