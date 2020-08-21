package com.zxy.androiddemo.di

import com.zxy.androiddemo.data.RepositoryFactory
import com.zxy.androiddemo.data.DaoRepository
import com.zxy.androiddemo.db.dao.UserDao
import com.zxy.androiddemo.data.ApiRepositoryImpl
import com.zxy.androiddemo.http.ApiService
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
    fun provideRepository(userDao: UserDao): DaoRepository {
        return RepositoryFactory.makeUserRepository(userDao)
    }

    @Singleton
    @Provides
    fun provideRepositoryService(api: ApiService): ApiRepositoryImpl {
        return RepositoryFactory.makeUserRepositoryOfService(api)
    }
}