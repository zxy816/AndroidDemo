package com.zxy.androiddemo.data

import androidx.paging.PagingData
import com.zxy.androiddemo.db.entries.User
import kotlinx.coroutines.flow.Flow

/**
 * @author: zxy
 * @date: 2020/8/21
 * @des:
 */
interface ApiRepository {

    fun getServiceUser(): Flow<PagingData<User>>
}