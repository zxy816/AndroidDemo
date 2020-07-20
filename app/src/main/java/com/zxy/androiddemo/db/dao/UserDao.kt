package com.zxy.androiddemo.db.dao

import androidx.room.*
import com.zxy.androiddemo.db.entries.User

/**
 * @author: zxy
 * @date: 2018/7/11
 * @des:
 */
@Dao
interface UserDao {
    /**
     * 查找所有的用户
     *
     * @return
     */
    @Query("select * from users")
    fun getUsers(): List<User>

    /**
     * 分页查找
     */
    @Query("select * from users where uid between :startIndex and :endIndex")
    fun getUsersPaging(startIndex: Int, endIndex: Int): List<User>

    /**
     * 根据性别查找用户
     *
     * @param sex
     * @return
     */
    @Query("select * from users where sex is (:sex)")
    fun getUsersBySex(sex: String): List<User>

    /**
     * 根据手机号码来查找用户
     *
     * @param phone
     * @return
     */
    @Query("select * from users where phone is (:phone)")
    fun getUserByPhone(phone: String): User

    /**
     * 插入用户
     *
     * @param user
     * @return
     */
    @Insert
    fun inserUsers(user: User): Long

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    @Update
    fun updateUser(user: User): Int

    /**
     * 删除用户
     *
     * @param user
     * @return
     */
    @Delete
    fun deleteUser(user: User): Int
}
