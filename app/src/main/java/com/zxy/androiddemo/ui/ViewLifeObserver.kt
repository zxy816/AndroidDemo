package com.zxy.androiddemo.ui

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * @author: zxy
 * @date: 2021/4/12
 * @des:
 */
class ViewLifeObserver : LifecycleObserver {

    private val TAG: String = ViewLifeObserver::class.java.simpleName

    @OnLifecycleEvent(value = Lifecycle.Event.ON_CREATE)
    fun onCrate() {
        Log.i(TAG, "lifecycle_onCrate()")

    }

    @OnLifecycleEvent(value = Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Log.i(TAG, "lifecycle_onResume()")

    }

    @OnLifecycleEvent(value = Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.i(TAG, "lifecycle_onPause()")

    }

    @OnLifecycleEvent(value = Lifecycle.Event.ON_STOP)
    fun onStop() {
        Log.i(TAG, "lifecycle_onStop()")

    }

}