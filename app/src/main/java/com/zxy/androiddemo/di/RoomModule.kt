package com.zxy.androiddemo.di

import android.content.Context
import com.zxy.androiddemo.db.AppDatabase
import com.zxy.androiddemo.db.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author: zxy
 * @date: 2020/8/17
 * @des:
 */
@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Provides
    @Singleton
    fun provideAppDataBase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    @Singleton
    fun provideUserDao(appDataBase: AppDatabase): UserDao {
        return appDataBase.userDao()
    }
}