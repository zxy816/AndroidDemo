package com.zxy.androiddemo.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

import com.zxy.androiddemo.db.dao.UserDao
import com.zxy.androiddemo.db.entries.User
import org.jetbrains.anko.doAsync

/**
 * @author: zxy
 * @date: 2018/7/11
 * @des:
 */
@Database(entities = arrayOf(User::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        private var instance: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {
                synchronized(AppDatabase::class.java) {
                    if (instance == null) {
                        if (context != null) {
                            instance = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "demo.db")
                                    .addCallback(object : Callback() {
                                        override fun onCreate(db: SupportSQLiteDatabase) {
                                            super.onCreate(db)
                                            initUsersDataBase(context)
                                        }
                                    })
                                    //.addMigrations(MIGRATION_1_2)
                                    .allowMainThreadQueries().build()
                        }
                    }
                }
            }
            return instance
        }

        internal val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("")
            }
        }

        fun initUsersDataBase(context: Context) {
            doAsync {
                for (i in 0..100) {
                    val user = User()
                    user.userName = "zxy$i"
                    user.pwd = "123456"
                    if (i % 2 == 0) user.sex = "男" else "女"
                    user.age = i
                    getInstance(context)?.userDao()?.inserUsers(user)
                }
            }
        }
    }
}
