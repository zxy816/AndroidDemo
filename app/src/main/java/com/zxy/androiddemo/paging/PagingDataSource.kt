package com.zxy.androiddemo.paging

import androidx.paging.ItemKeyedDataSource
import com.zxy.androiddemo.db.business.UserSourceImpl

import com.zxy.androiddemo.db.entries.User

class PagingDataSource(private val userSourceImpl: UserSourceImpl) : ItemKeyedDataSource<Int, User>() {

    override fun loadInitial(params: ItemKeyedDataSource.LoadInitialParams<Int>, callback: ItemKeyedDataSource.LoadInitialCallback<User>) {
        val list = userSourceImpl.getUserPaging(0, params.requestedLoadSize)
        callback.onResult(list)
    }

    override fun loadAfter(params: ItemKeyedDataSource.LoadParams<Int>, callback: ItemKeyedDataSource.LoadCallback<User>) {
        val list = userSourceImpl.getUserPaging(params.key.toInt(), params.requestedLoadSize)
        list?.let {
            callback.onResult(list)
        }
    }

    override fun loadBefore(params: ItemKeyedDataSource.LoadParams<Int>, callback: ItemKeyedDataSource.LoadCallback<User>) {
        val list = userSourceImpl.getUserPaging(params.key.toInt(), params.requestedLoadSize)
        list?.let {
            callback.onResult(list)
        }
    }

    override fun getKey(item: User): Int {
        return item.uid
    }
}
