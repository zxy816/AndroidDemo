package com.zxy.androiddemo.app

import android.content.Context
import android.util.Log
import androidx.startup.Initializer

/**
 * @author: zxy
 * @date: 2020/8/25
 * @des: 其他库初始化
 * 1.引入App Startup的库
 * 2.自定义一个用于初始化的Initializer
 * 3.将自定义Initializer配置到AndroidManifest.xml当中
 */
class DemoInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        //初始化
        Log.i("DemoInitializer", "DemoInitializer_create()")
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        //上面是否还依赖于其他的Initializer，如果有的话，就在这里进行配置
        return emptyList()
    }
}