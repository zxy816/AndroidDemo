package com.zxy.androiddemo.http

import com.google.gson.JsonObject
import com.zxy.androiddemo.bean.PagingResponse
import com.zxy.androiddemo.bean.YouDaoResult
import com.zxy.androiddemo.db.entries.User
import retrofit2.http.*

/**
 * @author: zxy
 * @date: 2020/8/21
 * @des:
 */
interface ApiService {
    @GET("search/repositories?sort=stars&q=Android")
    suspend fun getTestData(@Query("page") page: Int, @Query("per_page") perPage: Int): PagingResponse

    @POST("users")
    fun getUser(@Query("id") id: Int): User

    @FormUrlEncoded
    @POST("translate?doctype=json")
    suspend fun translate(@Field("i") i: String): ApiResult<YouDaoResult>

    @POST("lottery/V1/bet")
    suspend fun lotteryBet(@Body params: JsonObject): ApiResult<Any>
}