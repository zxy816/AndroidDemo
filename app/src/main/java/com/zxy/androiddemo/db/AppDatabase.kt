package com.zxy.androiddemo.db

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.migration.Migration
import android.content.Context

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
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "demo.db")
                                //.addMigrations(MIGRATION_1_2)
                                .allowMainThreadQueries().build()
                    }
                }
            }
            return INSTANCE
        }

        internal val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("")
            }
        }
    }
}
