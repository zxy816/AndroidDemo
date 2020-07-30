package com.zxy.androiddemo.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

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

    companion object {

        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context?): AppDatabase? {
            if (instance == null) {
                synchronized(AppDatabase::class.java) {
                    if (instance == null) {
                        if (context != null) {
                            instance = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "demo.db")
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
    }
}
