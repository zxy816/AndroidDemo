package com.zxy.androiddemo.http

import com.zxy.androiddemo.db.entries.User
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author: zxy
 * @date: 2020/8/21
 * @des:
 */
interface ApiService {
    @GET("users")
    suspend fun getTestData(@Query("since") id: Int, @Query("per_page") perPage: Int): List<User>



    @GET("users")
    fun getUser(@Query("id") id: Int): User
}