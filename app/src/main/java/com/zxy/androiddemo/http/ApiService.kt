package com.zxy.androiddemo.http

import com.google.gson.JsonObject
import com.zxy.androiddemo.bean.PagingResponse
import com.zxy.androiddemo.bean.VirHome
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

    @Headers("App-Token:\$2a\$10\$8wvft25Ik0JP/p3SyG4x7und65cXTiB.fs66w9HeSlNA45vuhQhMW")
    @FormUrlEncoded
    @POST("main")
    suspend fun getVirHome(@Field("userName") userName: String): VirHome

    @FormUrlEncoded
    @POST("translate?doctype=json")
    suspend fun translate(@Field("i") i: String): ApiResult<YouDaoResult>

    @POST("lottery/V1/bet")
    suspend fun lotteryBet(@Body params: JsonObject): ApiResult<Any>
}