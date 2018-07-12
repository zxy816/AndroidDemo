package com.zxy.androiddemo.paging

import android.arch.paging.DataSource

import com.zxy.androiddemo.bean.PagBean

/**
 * @author: zxy
 * @date: 2018/7/12
 * @des:
 */
class PagingDataSourceFactory(val repository: DataRepository) : DataSource.Factory<Int, PagBean>() {

    override fun create(): DataSource<Int, PagBean> {
        return PagingDataSource(repository)
    }
}
