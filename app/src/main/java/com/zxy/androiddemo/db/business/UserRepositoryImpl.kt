package com.zxy.androiddemo.db.business

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.zxy.androiddemo.db.AppDatabase
import com.zxy.androiddemo.db.entries.User
import kotlinx.coroutines.flow.Flow

/**
 * @author: zxy
 * @date: 2020/7/31
 * @des:
 */
class UserRepositoryImpl(val db: AppDatabase, val pageConfig: PagingConfig) : UserRepository {

    private val userDao by lazy { db.userDao() }

    override fun insertUser(user: User) {
        userDao.inserUsers(user)
    }

    override fun getAllUsers(): Flow<PagingData<User>> {
        return Pager(pageConfig) {
            userDao.getUsers()
        }.flow
    }
}