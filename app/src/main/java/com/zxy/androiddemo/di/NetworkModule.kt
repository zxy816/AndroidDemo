package com.zxy.androiddemo.di

import com.zxy.androiddemo.http.ApiService
import com.zxy.androiddemo.http.HttpLoggingIntercepter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.RequestBody
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

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val builder = OkHttpClient.Builder()
                .connectTimeout(timeOut, TimeUnit.SECONDS)
                .writeTimeout(readTimeOut, TimeUnit.SECONDS)
                .readTimeout(readTimeOut, TimeUnit.SECONDS)

                .retryOnConnectionFailure(true)
                .addInterceptor(interceptor)
                .addInterceptor(HttpLoggingIntercepter())
        //拦截发送的内容
//        setRequestJson(builder)
        return builder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val retrofit = Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://192.168.9.89:9680")
                .addConverterFactory(GsonConverterFactory.create())
        return retrofit.build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    fun setRequestJson(builder: OkHttpClient.Builder) {
        builder.addInterceptor {
            val request = it.request()
            val requestBuilder = request.newBuilder()
            requestBuilder.addHeader("Content-Type", "application/json;charset=UTF-8")
                    //bodyToString(request.body()) 是请求发送的json内容
                    .post(RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), bodyToString(request.body())))
                    .build()
            return@addInterceptor it.proceed(request)
        }
    }

    fun bodyToString(request: RequestBody?): String? {
        return try {
            val buffer = Buffer()
            if (request != null) request.writeTo(buffer) else ""
            buffer.readUtf8()
        } catch (e: IOException) {
            e.message
        }
    }
}