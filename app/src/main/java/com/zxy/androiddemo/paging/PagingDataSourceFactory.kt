package com.zxy.androiddemo.paging

import androidx.paging.DataSource

import com.zxy.androiddemo.db.entries.User

class PagingDataSourceFactory(val userSourceImpl: UserSourceImpl) : DataSource.Factory<Int, User>() {

    override fun create(): DataSource<Int, User> {
        return PagingDataSource(userSourceImpl)
    }
}
