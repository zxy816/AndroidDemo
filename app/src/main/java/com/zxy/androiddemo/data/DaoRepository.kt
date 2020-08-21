package com.zxy.androiddemo.data

import androidx.paging.PagingData
import com.zxy.androiddemo.db.entries.User
import kotlinx.coroutines.flow.Flow

/**
 * @author: zxy
 * @date: 2020/7/31
 * @des:
 */
interface DaoRepository {

    fun insertUser(user: User)

    fun getAllUsers(): Flow<PagingData<User>>

}