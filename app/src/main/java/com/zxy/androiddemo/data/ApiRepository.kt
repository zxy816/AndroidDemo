package com.zxy.androiddemo.data

import androidx.paging.PagingData
import com.zxy.androiddemo.bean.PagingBean
import com.zxy.androiddemo.bean.YouDaoResult
import com.zxy.androiddemo.http.ApiResult
import kotlinx.coroutines.flow.Flow

/**
 * @author: zxy
 * @date: 2020/8/21
 * @des:
 */
interface ApiRepository {

    fun getServiceUser(): Flow<PagingData<PagingBean>>

    suspend fun translate(word: String): ApiResult<YouDaoResult>
}