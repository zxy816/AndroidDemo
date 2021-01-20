package com.zxy.androiddemo.http

import java.io.IOException

/**
 * @author: zxy
 * @date: 2021/1/20
 * @des:
 */
class ApiException(val errorCode: Int, val errorMsg: String) : IOException()


object ApiError {
    //数据是null
    val dataIsNull = ApiException(-1, "data is null")

    //http status code 不是 成功
    val httpStatusCodeError = ApiException(-2, "Server error. Please try again later.")

    //未知异常
    val unknownException = ApiException(-3, "unknown exception")
}