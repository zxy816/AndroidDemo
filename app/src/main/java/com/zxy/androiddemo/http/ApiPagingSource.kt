package com.zxy.androiddemo.http

import androidx.paging.PagingSource
import com.zxy.androiddemo.db.entries.User
import java.lang.Exception

/**
 * @author: zxy
 * @date: 2020/8/21
 * @des:
 */
class ApiPagingSource(val api: ApiService) : PagingSource<Int, User>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        return try {
            val key = params.key ?: 0
            // 获取网络数据
            val items = api.getTestData(key, params.loadSize)
            // 请求成功，构造一个 LoadResult.Page 返回
            LoadResult.Page(
                    data = items,// 返回获取到的数据
                    prevKey = null,// 上一页,如果是第一页需要返回 null，否则会出现多次请求
                    nextKey = items.lastOrNull()?.uid // 下一页,如果是最后一页返回 null
            )
        } catch (e: Exception) {
            e.printStackTrace()
            // 请求失败或者出现异常，会跳转到 case 语句返回 LoadResult.Error(e)
            LoadResult.Error(e)
        }
    }
}