package com.zxy.androiddemo.http

import com.zxy.androiddemo.bean.PagingBean
import com.zxy.androiddemo.db.entries.User
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

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
}