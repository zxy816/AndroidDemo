package com.zxy.androiddemo.app

import android.app.Application
import androidx.multidex.MultiDex
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * @author: zxy
 * @date: 2018/7/11
 * @des:
 */
class DemoApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@DemoApp)
            modules(appModule)
        }
        MultiDex.install(this)
    }
}
