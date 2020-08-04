package com.zxy.androiddemo.app

import com.zxy.androiddemo.db.AppDatabase
import com.zxy.androiddemo.db.RepositoryFactory
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * @author: zxy
 * @date: 2020/8/4
 * @des:
 */
val dbModule = module {
    single { AppDatabase.getInstance(androidApplication()) }
}

val appModule = listOf(dbModule)