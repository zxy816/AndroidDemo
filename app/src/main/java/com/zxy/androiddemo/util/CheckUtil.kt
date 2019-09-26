package com.zxy.androiddemo.util

import android.text.TextUtils
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import java.lang.IllegalArgumentException

/**
 * @author: zxy
 * @date: 2019/9/25
 * @des:
 */
object CheckUtil {

    @NonNull
    fun <T> checkNotNull(@Nullable arg: T): T {
        return checkNotNull(arg, "Argument must not be null")
    }

    @NonNull
    fun <T> checkNotNull(@Nullable arg: T, @Nullable message: String): T {
        if (arg == null) {
            throw NullPointerException(message)
        }
        return arg
    }

    @NonNull
    fun checkNotEmpty(@Nullable str: String): String {
        if (TextUtils.isEmpty(str)) {
            throw IllegalArgumentException("must not null or empty")
        }
        return str
    }

}