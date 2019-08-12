package com.zxy.androiddemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.zxy.androiddemo.db.business.UserSourceImpl
import com.zxy.androiddemo.paging.PagingDataSourceFactory

/**
 * @author: zxy
 * @date: 2019/8/8
 * @des:
 */
class UserModel constructor(userSourceImpl: UserSourceImpl) : ViewModel() {


    val users = LivePagedListBuilder(PagingDataSourceFactory(userSourceImpl), PagedList.Config.Builder()
            //分页加载的数量
            .setPageSize(20)
            //预加载的数量
            .setInitialLoadSizeHint(20)
            .setEnablePlaceholders(true).build()
    ).build()
}