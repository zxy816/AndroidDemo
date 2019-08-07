package com.zxy.androiddemo.db.entries

import android.graphics.Bitmap
import androidx.room.*

/**
 * @author: zxy
 * @date: 2018/7/11
 * @des:
 */
@Entity(tableName = "users")
class User {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "uid")
    var uid: Int = 0

    @ColumnInfo(name = "username")
    var userName: String? = null

    @ColumnInfo(name = "pwd")
    var pwd: String? = null

    @ColumnInfo(name = "age")
    var age: Int = 0

    @ColumnInfo(name = "sex")
    var sex: String? = null

    @ColumnInfo(name = "education")
    var education: String? = null

    @ColumnInfo(name = "phone")
    var phone: String? = null

    @Embedded
    var address: Address? = null
    //头像
    @Ignore
    var avatar: Bitmap? = null

    override fun toString(): String {
        return "User(uid=$uid, userName=$userName, pwd=$pwd, age=$age, sex=$sex, education=$education, phone=$phone, address=$address, avatar=$avatar)"
    }


}