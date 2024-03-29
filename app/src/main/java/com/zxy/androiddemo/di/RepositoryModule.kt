package com.zxy.androiddemo.di

import com.zxy.androiddemo.data.ApiRepository
import com.zxy.androiddemo.data.DaoRepository
import com.zxy.androiddemo.data.RepositoryFactory
import com.zxy.androiddemo.db.dao.UserDao
import com.zxy.androiddemo.http.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author: zxy
 * @date: 2020/8/17
 * @des:
 */
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideRepository(userDao: UserDao): DaoRepository {
        return RepositoryFactory.makeUserRepository(userDao)
    }

    @Singleton
    @Provides
    fun provideRepositoryService(api: ApiService): ApiRepository {
        return RepositoryFactory.makeUserRepositoryOfService(api)
    }
}