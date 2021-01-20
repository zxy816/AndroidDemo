package com.zxy.androiddemo.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.zxy.androiddemo.db.AppDatabase
import com.zxy.androiddemo.db.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
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
        return Room.databaseBuilder(application, AppDatabase::class.java, "demo.db")
                .addCallback(callback)
                .addMigrations(MIGRATION_1_2)
                .allowMainThreadQueries()
                .build()
    }

    @Provides
    @Singleton
    fun provideUserDao(appDataBase: AppDatabase): UserDao {
        return appDataBase.userDao()
    }

    private val callback: RoomDatabase.Callback = object : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
        }
    }

    private val MIGRATION_1_2: Migration = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("")
        }
    }
}