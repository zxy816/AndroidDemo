package com.zxy.androiddemo.di

import android.util.Log
import com.zxy.androiddemo.http.ApiService
import com.zxy.androiddemo.http.HttpLoggingIntercepter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import okio.Buffer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * @author: zxy
 * @date: 2020/8/21
 * @des:hilt 网络
 */
@InstallIn(ApplicationComponent::class)
@Module
class NetworkModule {
    private val timeOut: Long = 5
    private val readTimeOut: Long = 10
    private val tag: String = NetworkModule::class.java.simpleName
    private val baseUrl1 = "https://api.github.com/"
    private val baseUrl2 = "http://fanyi.youdao.com/"
    private val baseUrl3 = "http://180.167.143.4:9680/"

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = getLoggingInterceptor(HttpLoggingInterceptor.Level.BODY)
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val builder = OkHttpClient.Builder()
                .connectTimeout(timeOut, TimeUnit.SECONDS)
                .writeTimeout(readTimeOut, TimeUnit.SECONDS)
                .readTimeout(readTimeOut, TimeUnit.SECONDS)

                .retryOnConnectionFailure(true)
                .addInterceptor(interceptor)
                .addInterceptor(HttpLoggingIntercepter())
        //拦截发送的内容
        setRequestJson(builder)
        return builder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val retrofit = Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseUrl1)
                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(ApiCallAdapterFactory.invoke())
        return retrofit.build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    /**
     * 拦截请求信息
     */
    private fun getLoggingInterceptor(level: HttpLoggingInterceptor.Level): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor { message: String ->
            Log.i(tag, message)
        }
        loggingInterceptor.level = level
        return loggingInterceptor
    }

    private fun setRequestJson(builder: OkHttpClient.Builder) {
        builder.addInterceptor {
            val request = it.request()
            val requestBuilder = request.newBuilder()
            // 请求发送内容
            val requestContent = bodyToString(request.body())
            requestBuilder.addHeader("Content-Type", "application/json;charset=UTF-8")
                    .post(RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), requestContent))
                    .build()
            // 获取请求返回信息
            val response = it.proceed(request)
            val contentType = response.body()?.contentType();
            val responseContent = response.body()?.string();
            Log.i(tag, "请求地址: ${request.url()}")
            Log.i(tag, "请求内容: $requestContent")
            Log.i(tag, "返回内容: $responseContent")
            return@addInterceptor response.newBuilder().body(
                    ResponseBody.create(contentType, responseContent)).build()
        }
    }

    private fun bodyToString(request: RequestBody?): String? {
        return try {
            val buffer = Buffer()
            if (request != null) request.writeTo(buffer) else ""
            buffer.readUtf8()
        } catch (e: IOException) {
            e.message
        }
    }
}