package com.zxy.androiddemo.app

import android.app.Application
import androidx.multidex.MultiDex
import dagger.hilt.android.HiltAndroidApp


/**
 * @author: zxy
 * @date: 2018/7/11
 * @des:
 */
@HiltAndroidApp
class DemoApp : Application() {

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)
    }
}
