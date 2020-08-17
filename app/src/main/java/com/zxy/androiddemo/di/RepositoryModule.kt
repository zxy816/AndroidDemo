package com.zxy.androiddemo.di

import com.zxy.androiddemo.db.AppDatabase
import com.zxy.androiddemo.db.RepositoryFactory
import com.zxy.androiddemo.db.business.UserRepository
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
@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideRepository(appDatabase: AppDatabase): UserRepository {
        return RepositoryFactory.makeUserRepository(appDatabase)
    }
}