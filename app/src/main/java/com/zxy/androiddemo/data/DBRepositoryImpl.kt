package com.zxy.androiddemo.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.zxy.androiddemo.db.dao.UserDao
import com.zxy.androiddemo.db.entries.User
import kotlinx.coroutines.flow.Flow

/**
 * @author: zxy
 * @date: 2020/7/31
 * @des:
 */
class DBRepositoryImpl(val userDao: UserDao, val pageConfig: PagingConfig) : DaoRepository {

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