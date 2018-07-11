package com.zxy.androiddemo.db.business

import com.zxy.androiddemo.db.business.impl.UserSource
import com.zxy.androiddemo.db.dao.UserDao
import com.zxy.androiddemo.db.entries.User

/**
 * @author: zxy
 * @date: 2018/7/11
 * @des:
 */
class UserSourceImpl(private val userDao: UserDao) : UserSource {

    override fun getUsers(): List<User> {
        return userDao.getUsers()
    }

    override fun getUsersBySex(sex: String): List<User> {
        return userDao.getUsersBySex(sex)
    }

    override fun getUsersByPhone(phone: String): User {
        return userDao.getUserByPhone(phone)
    }


    override fun insertUser(user: User) {
        userDao.inserUsers(user)
    }

    override fun updateUser(user: User): Int {
        return userDao.updateUser(user)
    }

    override fun deleteUser(user: User): Int {
        return userDao.deleteUser(user)
    }
}
