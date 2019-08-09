package com.zxy.androiddemo.viewmodel

import android.content.Context
import com.zxy.androiddemo.db.DbDataProvider
import com.zxy.androiddemo.db.business.UserSourceImpl
import com.zxy.androiddemo.viewmodel.factory.UserModelFactory

/**
 * @author: zxy
 * @date: 2019/8/9
 * @des:
 */
object ViewModelFactoryProvider{
    fun providerUserModel(context : Context) : UserModelFactory {
        val userSourceImpl: UserSourceImpl = DbDataProvider.provideUserDao(context)
        return UserModelFactory(userSourceImpl)
    }
}