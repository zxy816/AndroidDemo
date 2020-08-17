package com.zxy.androiddemo.db

import androidx.paging.PagingConfig
import com.zxy.androiddemo.db.business.UserRepository
import com.zxy.androiddemo.db.business.UserRepositoryImpl

/**
 * 数据 储存库工厂
 */
object RepositoryFactory{

    fun makeUserRepository(appDatabase: AppDatabase): UserRepository = UserRepositoryImpl(appDatabase, pagingConfig)

    val pagingConfig = PagingConfig(
            // 每页显示的数据的大小
            pageSize = 20,
            // 开启占位符
            enablePlaceholders = true,
            // 预刷新的距离，距离最后一个 item 多远时加载数据
            prefetchDistance = 3,
            // 初始化加载数量，默认为 pageSize * 3
            initialLoadSize = 60,
            //内存中保存的最大数据.超过滑动加载更多的数据
            maxSize = 100
    )
}
