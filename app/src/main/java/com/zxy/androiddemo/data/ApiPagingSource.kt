package com.zxy.androiddemo.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.zxy.androiddemo.bean.PagingBean
import com.zxy.androiddemo.http.ApiLoader
import com.zxy.androiddemo.http.ApiService
import java.lang.Exception

/**
 * @author: zxy
 * @date: 2020/8/21
 * @des: 网络请求分页显示
 */
class ApiPagingSource(private val api: ApiService) : PagingSource<Int, PagingBean>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PagingBean> {
        return try {
            val pageNumber = params.key ?: 1
            val pageSize = params.loadSize
            // 获取网络数据 - 请求成功，构造一个 LoadResult.Page 返回
            val pagingResponse = api.getTestData(pageNumber, pageSize)

            val items = pagingResponse.items
            val prevKey = if (pageNumber > 1) pageNumber - 1 else null
            val nextKey = if (items.isNotEmpty()) pageNumber + 1 else null
            LoadResult.Page(
                    // 返回获取到的数据
                    items,
                    // 上一页,如果是第一页需要返回 null，否则会出现多次请求
                    prevKey,
                    // 下一页,如果是最后一页返回 null
                    nextKey
            )
        } catch (e: Exception) {
            e.printStackTrace()
            // 请求失败或者出现异常，会跳转到 case 语句返回 LoadResult.Error(e)
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, PagingBean>): Int? {
        return null
    }
}