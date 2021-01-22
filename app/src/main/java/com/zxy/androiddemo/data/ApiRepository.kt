package com.zxy.androiddemo.data

import androidx.paging.PagingData
import com.zxy.androiddemo.bean.PagingBean
import kotlinx.coroutines.flow.Flow

/**
 * @author: zxy
 * @date: 2020/8/21
 * @des:
 */
interface ApiRepository {

    fun getServiceUser(): Flow<PagingData<PagingBean>>
}