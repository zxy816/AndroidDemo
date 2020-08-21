package com.zxy.androiddemo.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.zxy.androiddemo.db.entries.User
import com.zxy.androiddemo.http.ApiPagingSource
import com.zxy.androiddemo.http.ApiService
import kotlinx.coroutines.flow.Flow

/**
 * @author: zxy
 * @date: 2020/8/21
 * @des:
 */
class ApiRepositoryImpl(val api: ApiService, val pageConfig: PagingConfig) : ApiRepository {
    /**
     * 从网络上获取数据进行分页
     */
    override fun getServiceUser(): Flow<PagingData<User>> {
        return Pager(pageConfig) {
            ApiPagingSource(api)
        }.flow
    }

}