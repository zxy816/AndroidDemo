package com.zxy.androiddemo.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.zxy.androiddemo.db.business.UserRepository
import com.zxy.androiddemo.db.entries.Address
import com.zxy.androiddemo.db.entries.User
import org.jetbrains.anko.doAsync

class RegistViewModel @ViewModelInject constructor(val userRepository: UserRepository) : ViewModel() {

    fun registerUserDB() {
        doAsync {
            for (i in 0..100) {
                val user = User()
                user.userName = "zxy$i"
                user.pwd = "123456"
                user.sex = if (i % 2 == 0) "男" else "女"
                user.age = i
                user.phone = "18792430923"
                val address = Address()
                address.province = "陕西省"
                address.city = "西安市"
                address.county = "雁塔区"
                userRepository.insertUser(user)
            }
        }
    }
}
