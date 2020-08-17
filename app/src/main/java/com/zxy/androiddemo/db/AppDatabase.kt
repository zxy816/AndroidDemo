package com.zxy.androiddemo.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zxy.androiddemo.db.dao.UserDao
import com.zxy.androiddemo.db.entries.User

/**
 * @author: zxy
 * @date: 2018/7/11
 * @des:
 */
@Database(entities = arrayOf(User::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
