package com.zxy.androiddemo.http

import com.trello.rxlifecycle4.android.ActivityEvent
import com.trello.rxlifecycle4.components.support.RxAppCompatActivity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableTransformer
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * @author: zxy
 * @date: 2021/11/30
 * @des:统一线程处理
 */
class RxUtil {
    companion object {
        /**
         * @return 转换后的ObservableTransformer
         */
        fun <T> applySchedulers(): ObservableTransformer<T, T> {
            return ObservableTransformer<T, T> { observable ->
                observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
            }
        }

        /**
         * @param activity    Activity
         * @param showLoading 是否显示Loading
         * @return
         */
        fun <T> applySchedulers(
            activity: RxAppCompatActivity?,
            showLoading: String?
        ): ObservableTransformer<T, T> {
            return if (activity == null) {
                applySchedulers()
            } else ObservableTransformer { observable: Observable<T> ->
                val compose = observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .compose(activity.bindUntilEvent(ActivityEvent.DESTROY))
                compose.compose(ProgressUtils.applyProgress(activity, showLoading))
            }
        }
    }
}