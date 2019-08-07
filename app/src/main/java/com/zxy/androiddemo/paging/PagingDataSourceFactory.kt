package com.zxy.androiddemo.paging

import androidx.paging.DataSource

import com.zxy.androiddemo.db.entries.User

/**
 * @author: zxy
 * @date: 2018/7/12
 * @des:
 */
class PagingDataSourceFactory(val repository: DataRepository) : DataSource.Factory<Int, User>() {

    override fun create(): DataSource<Int, User> {
        return PagingDataSource(repository)
    }
}
