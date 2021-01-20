package com.zxy.androiddemo.http

import java.io.IOException

/**
 * @author: zxy
 * @date: 2021/1/19
 * @des: 请求返回密封类
 */
sealed class ApiResult<out T> {
    data class Success<out T>(val data: T) : ApiResult<T>()
    data class Failure(val errorCode: Int, val errorMsg: String) : ApiResult<Nothing>()
}


