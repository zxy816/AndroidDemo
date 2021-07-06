package com.zxy.androiddemo.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.zxy.androiddemo.bean.PagingBean
import com.zxy.androiddemo.bean.VirHome
import com.zxy.androiddemo.http.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * @author: zxy
 * @date: 2020/8/21
 * @des:
 */
class ApiRepositoryImpl(private val api: ApiService, private val pageConfig: PagingConfig) : ApiRepository {

    /**
     * 从网络上获取数据进行分页
     */
    override fun getHubAndroid(): Flow<PagingData<PagingBean>> {
        return Pager(pageConfig) {
            ApiPagingSource(api)
        }.flow
    }


    override fun getVirApiHome(userName: String): Flow<VirHome> {
        return flow {
            api.getVirHome(userName)
        }
    }
}