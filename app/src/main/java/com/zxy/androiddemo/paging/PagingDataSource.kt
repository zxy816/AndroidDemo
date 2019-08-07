package com.zxy.androiddemo.paging

import androidx.paging.ItemKeyedDataSource

import com.zxy.androiddemo.db.entries.User

/**
 * @author: zxy
 * @date: 2018/7/12
 * @des:
 */
class PagingDataSource(private val repository: DataRepository) : ItemKeyedDataSource<Int, User>() {

    override fun loadInitial(params: ItemKeyedDataSource.LoadInitialParams<Int>, callback: ItemKeyedDataSource.LoadInitialCallback<User>) {
        val list = repository.loadData(params.requestedLoadSize)
        callback.onResult(list)
    }

    override fun loadAfter(params: ItemKeyedDataSource.LoadParams<Int>, callback: ItemKeyedDataSource.LoadCallback<User>) {
        val list = repository.loadData(params.key.toInt(), params.requestedLoadSize)
        list?.let {
            callback.onResult(list)
        }
    }

    override fun loadBefore(params: ItemKeyedDataSource.LoadParams<Int>, callback: ItemKeyedDataSource.LoadCallback<User>) {
        val list = repository.loadData(params.key.toInt(), params.requestedLoadSize)
        list?.let {
            callback.onResult(list)
        }
    }

    override fun getKey(item: User): Int {
        return item.uid
    }
}
