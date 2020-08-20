package com.zxy.androiddemo.db.business

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.zxy.androiddemo.db.dao.UserDao
import com.zxy.androiddemo.db.entries.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * @author: zxy
 * @date: 2020/7/31
 * @des:
 */
class UserRepositoryImpl(val userDao: UserDao, val pageConfig: PagingConfig) : UserRepository {

    override fun insertUser(user: User) {
        userDao.inserUsers(user)
    }

    override fun getAllUsers(): Flow<PagingData<User>> {
        return Pager(pageConfig) {
            println("========" + Thread.currentThread().name)
            userDao.getUsers()
        }.flow
    }
}