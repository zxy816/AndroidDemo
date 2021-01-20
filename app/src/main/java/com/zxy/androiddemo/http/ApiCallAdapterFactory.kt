package com.zxy.androiddemo.http

import okhttp3.Request
import okio.Timeout
import retrofit2.*
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * @author: zxy
 * @date: 2021/1/20
 * @des:
 */
class ApiCallAdapterFactory private constructor() : CallAdapter.Factory() {
    companion object {
        @JvmStatic
        @JvmName("create")
        operator fun invoke() = ApiCallAdapterFactory()
    }

    override fun get(returnType: Type, annotations: Array<Annotation>, retrofit: Retrofit): CallAdapter<*, *>? {
        if (getRawType(returnType) != Call::class.java) {
            "$returnType must be retrofit2.Call."
        }
        check(returnType is ParameterizedType) { "$returnType must be parameterized. Raw types are not supported" }
        //取出Call<T> 里的T，检查是否是ApiResult<T>
        val apiResultType = getParameterUpperBound(0, returnType)

        check(getRawType(apiResultType) == ApiResult::class.java) { "$apiResultType must be ApiResult." }
        check(apiResultType is ParameterizedType) { "$apiResultType must be parameterized. Raw types are not supported" }

        //取出ApiResult<T>中的T 也就是API返回数据对应的数据类型
        val dataType = getParameterUpperBound(0, apiResultType)
        return ApiResultCallAdapter<Any>(dataType)
    }
}

class ApiResultCallAdapter<T>(private val type: Type) : CallAdapter<T, Call<ApiResult<T>>> {
    override fun responseType(): Type = type

    override fun adapt(call: Call<T>): Call<ApiResult<T>> {
        return ApiResultCall(call)
    }
}

class ApiResultCall<T>(private val delegate: Call<T>) : Call<ApiResult<T>> {
    /**
     * 该方法会被Retrofit处理suspend方法的代码调用，并传进来一个callback,如果你回调了callback.onResponse，那么suspend方法就会成功返回
     * 如果你回调了callback.onFailure那么suspend方法就会抛异常
     */
    override fun enqueue(callback: Callback<ApiResult<T>>) {
        //delegate 实际的网络请求的Call<T>对象，网络请求的成功失败会回调不同的方法
        delegate.enqueue(object : Callback<T> {
            /**
             * 网络请求成功返回，会回调该方法（无论status code是不是200）
             */
            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (response.isSuccessful) {
                    val apiResult = if (response.body() == null) {
                        ApiResult.Failure(ApiError.dataIsNull.errorCode, ApiError.dataIsNull.errorMsg)
                    } else {
                        ApiResult.Success(response.body()!!)
                    }
                    callback.onResponse(this@ApiResultCall, Response.success(apiResult))
                } else {
                    val failureApiResult = ApiResult.Failure(ApiError.httpStatusCodeError.errorCode, ApiError.httpStatusCodeError.errorMsg)
                    callback.onResponse(this@ApiResultCall, Response.success(failureApiResult))
                }
            }

            /**
             * 在网络请求中发生了异常，会回调该方法
             */
            override fun onFailure(call: Call<T>, t: Throwable) {
                val failureApiResult = if (t is ApiException) {
                    ApiResult.Failure(t.errorCode, t.errorMsg)
                } else {
                    ApiResult.Failure(ApiError.unknownException.errorCode, ApiError.unknownException.errorMsg)
                }
                callback.onResponse(this@ApiResultCall, Response.success(failureApiResult))
            }

        })
    }

    override fun clone(): Call<ApiResult<T>> = ApiResultCall(delegate.clone())

    override fun execute(): Response<ApiResult<T>> {
        throw UnsupportedOperationException("ApiResultCall does not support synchronous execution")
    }

    override fun isExecuted(): Boolean = delegate.isExecuted

    override fun cancel() = delegate.cancel()

    override fun isCanceled(): Boolean = delegate.isCanceled

    override fun request(): Request = delegate.request()

    override fun timeout(): Timeout = delegate.timeout()
}