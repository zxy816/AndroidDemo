package com.zxy.androiddemo.data

import androidx.paging.PagingData
import com.zxy.androiddemo.bean.PagingBean
import com.zxy.androiddemo.bean.VirHome
import kotlinx.coroutines.flow.Flow

/**
 * @author: zxy
 * @date: 2020/8/21
 * @des:
 */
interface ApiRepository {

    fun getHubAndroid(): Flow<PagingData<PagingBean>>

    fun getVirApiHome(userName: String): Flow<VirHome>
}