package com.zxy.androiddemo.paging

import android.arch.paging.ItemKeyedDataSource

import com.zxy.androiddemo.bean.PagBean

/**
 * @author: zxy
 * @date: 2018/7/12
 * @des:
 */
class PagingDataSource(private val repository: DataRepository) : ItemKeyedDataSource<Int, PagBean>() {

    override fun loadInitial(params: ItemKeyedDataSource.LoadInitialParams<Int>, callback: ItemKeyedDataSource.LoadInitialCallback<PagBean>) {
        val list = repository.loadData(params.requestedLoadSize)
        callback.onResult(list)
    }

    override fun loadAfter(params: ItemKeyedDataSource.LoadParams<Int>, callback: ItemKeyedDataSource.LoadCallback<PagBean>) {
        val list = repository.loadData(params.key.toInt(), params.requestedLoadSize)
        list?.let {
            callback.onResult(list)
        }
    }

    override fun loadBefore(params: ItemKeyedDataSource.LoadParams<Int>, callback: ItemKeyedDataSource.LoadCallback<PagBean>) {
        val list = repository.loadData(params.key.toInt(), params.requestedLoadSize)
        list?.let {
            callback.onResult(list)
        }
    }

    override fun getKey(item: PagBean): Int {
        return item.code
    }
}
