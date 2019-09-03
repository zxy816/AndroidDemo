package com.zxy.androiddemo.app

import android.app.Application
import androidx.multidex.MultiDex

/**
 * @author: zxy
 * @date: 2018/7/11
 * @des:
 */
class DemoApp : Application() {

    companion object {
        lateinit var  application: Application
    }

    override fun onCreate() {
        super.onCreate()
        application = this
        MultiDex.install(this)
    }
}
