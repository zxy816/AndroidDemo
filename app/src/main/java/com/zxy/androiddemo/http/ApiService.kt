package com.zxy.androiddemo.http

import com.zxy.androiddemo.bean.PagingBean
import com.zxy.androiddemo.bean.YouDaoResult
import com.zxy.androiddemo.db.entries.User
import retrofit2.http.*

/**
 * @author: zxy
 * @date: 2020/8/21
 * @des:
 */
interface ApiService {
    @POST("/")
    suspend fun getTestData(@Body params: HashMap<String, Any>): List<PagingBean>

    @POST("users")
    fun getUser(@Query("id") id: Int): User

    @FormUrlEncoded
    @POST("translate?doctype=json")
    suspend fun translate(@Field("i") i: String): ApiResult<YouDaoResult>
}