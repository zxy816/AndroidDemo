package com.zxy.androiddemo.http

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import okio.Buffer

/**
 * @author: zxy
 * @date: 2020/9/10
 * @des: 请求拦截
 */
class HttpLoggingIntercepter : Interceptor {
    private val tag = HttpLoggingIntercepter::class.java.simpleName
    override fun intercept(chain: Interceptor.Chain): Response {
        // 请求服务器数据
        val request = chain.request()
        val requestBody = request.body()
        var body: String? = null
        requestBody?.let {
            val buffer = Buffer()
            requestBody.writeTo(buffer)
            body = buffer.readUtf8()
        }
        Log.i(tag, " send request: url : ${request.url()},params : $body")
        //服务器返回数据
        val response = chain.proceed(request)
        val responseBody = response.body()
        val source = responseBody!!.source()
        source.request(java.lang.Long.MAX_VALUE)
        val buffer = source.buffer
        val rBody: String = buffer.clone().readUtf8()
        Log.i(tag, "response params : $rBody")
        return response
    }
}