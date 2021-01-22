package com.zxy.androiddemo.di

import android.content.Context
import com.zxy.androiddemo.db.AppDatabase
import com.zxy.androiddemo.db.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
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
    fun provideAppDataBase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    @Singleton
    fun provideUserDao(appDataBase: AppDatabase): UserDao {
        return appDataBase.userDao()
    }
}