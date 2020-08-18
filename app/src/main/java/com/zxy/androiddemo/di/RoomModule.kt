package com.zxy.androiddemo.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.zxy.androiddemo.db.AppDatabase
import com.zxy.androiddemo.db.dao.UserDao
import com.zxy.androiddemo.db.entries.User
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import org.jetbrains.anko.doAsync
import javax.inject.Singleton

/**
 * @author: zxy
 * @date: 2020/8/17
 * @des:
 */
@InstallIn(ApplicationComponent::class)
@Module
object RoomModule {
    @Provides
    @Singleton
    fun provideAppDataBase(application: Application): AppDatabase {
        println("========provideAppDataBase")
        return Room.databaseBuilder(application, AppDatabase::class.java, "demo.db")
                .addCallback(callback)
                .addMigrations(MIGRATION_1_2)
                .allowMainThreadQueries()
                .build()
    }

    @Provides
    @Singleton
    fun provideUserDao(appDataBase: AppDatabase): UserDao {
        println("===========provideUserDao")
        return appDataBase.userDao()
    }

    val callback: RoomDatabase.Callback = object : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            initUsersDataBase(db)
            println("========callback---onCreate()")
        }
    }

    internal val MIGRATION_1_2: Migration = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("")
        }
    }

    fun initUsersDataBase(db: SupportSQLiteDatabase) {
        doAsync {
            for (i in 0..100) {
                val user = User()
                user.userName = "zxy$i"
                user.pwd = "123456"
                if (i % 2 == 0) user.sex = "男" else "女"
                user.age = i
            }
        }
    }
}