package com.zxy.androiddemo.data

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.zxy.androiddemo.bean.PagingBean
import com.zxy.androiddemo.bean.VirHome
import com.zxy.androiddemo.http.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * @author: zxy
 * @date: 2020/8/21
 * @des:
 */
class ApiRepositoryImpl(
    private val api: ApiService,
    private val pageConfig: PagingConfig
) : ApiRepository {

    /**
     * 从网络上获取数据进行分页
     */
    override fun getHubAndroid(): Flow<PagingData<PagingBean>> {
        return Pager(pageConfig) {
            ApiPagingSource(api)
        }.flow
    }


    override suspend fun getVirApiHome(userName: String): Flow<VirHome> {
        return flow {
            try {
                //子线程
                Log.d("vir", "getVirApiHome-------${Thread.currentThread().name}")
                val virHome = api.getVirHome(userName)
                emit(virHome)
            } catch (e: Exception) {
                //发送请求失败信息
                Log.d("vir", "getVirApiHome_Exception-------${Thread.currentThread().name}")
                e.printStackTrace()
            }
        }.flowOn(Dispatchers.IO)
    }
}