package com.zxy.androiddemo.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zxy.androiddemo.db.business.UserSourceImpl
import com.zxy.androiddemo.viewmodel.UserModel

/**
 * @author: zxy
 * @date: 2019/8/9
 * @des:
 */
class UserModelFactory(private val userSourceImpl: UserSourceImpl) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserModel(userSourceImpl) as T
    }
}