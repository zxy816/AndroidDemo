package com.zxy.androiddemo.http

import android.app.Activity
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableTransformer
import java.lang.ref.WeakReference

/**
 * @author: zxy
 * @date: 2021/11/30
 * @des:
 */
class ProgressUtils {
    companion object {
        fun <T> applyProgress(context: Activity, tipMsg: String?): ObservableTransformer<T, T>? {
            val activityWeakReference = WeakReference(context)
            val dialogUtils = DialogUtils()
            dialogUtils.showProgress(activityWeakReference.get(), tipMsg)
            return ObservableTransformer { upstream: Observable<T> ->
                upstream.doOnSubscribe { }
                    .doOnTerminate {
                        val progress = activityWeakReference.get()
                        if (progress != null && !progress.isFinishing) {
                            dialogUtils.dismissProgress()
                        }
                    }
            }
        }
    }
}