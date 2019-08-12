package com.zxy.androiddemo.paging

import androidx.paging.PageKeyedDataSource
import com.zxy.androiddemo.db.business.UserSourceImpl
import com.zxy.androiddemo.db.entries.User

class PagingDataSource(private val userSourceImpl: UserSourceImpl) : PageKeyedDataSource<Int, User>() {
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, User>) {
        val list = userSourceImpl.getUserPaging(0, params.requestedLoadSize)
        callback.onResult(list,null,2)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {
        val startPage = params.key
        val startIndex = (startPage - 1) * 20 + 1
        val endIndex = startIndex + params.requestedLoadSize -1
        val list = userSourceImpl.getUserPaging(startIndex, endIndex)
        list?.let {
            callback.onResult(list,params.key + 1)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {
        val endPage = params.key
        val endIndex = (endPage - 1) * 20 + 1
        var startIndex = endIndex - params.requestedLoadSize
        startIndex = if (startIndex < 0) 0 else startIndex
        val list = userSourceImpl.getUserPaging(startIndex, endIndex)
        list?.let {
            callback.onResult(list,params.key + 1)
        }
    }
}
