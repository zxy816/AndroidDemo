package com.zxy.androiddemo.viewmodel

import androidx.lifecycle.ViewModel
import com.zxy.androiddemo.db.entries.Address
import com.zxy.androiddemo.db.entries.User

class RegistViewModel : ViewModel() {

    fun registerUserDB(){
        val user = User()
        user.userName = "zxy"
        user.pwd = "123456"
        user.sex = "男"
        user.age = 30
        user.phone = "18792430923"
        val address = Address()
        address.province = "陕西省"
        address.city = "西安市"
        address.county = "雁塔区"
        address.street = "电子城街道"
        user.address = address
    }

}
