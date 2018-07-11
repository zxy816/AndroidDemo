package com.zxy.androiddemo.db.business.impl

import com.zxy.androiddemo.db.entries.User

/**
 * @author: zxy
 * @date: 2018/7/11
 * @des:
 */
interface UserSource {
    fun getUsers(): List<User>

    fun getUsersBySex(sex: String): List<User>

    fun getUsersByPhone(phone: String): User

    fun insertUser(user: User)

    fun updateUser(user: User): Int

    fun deleteUser(user: User): Int

}
