package com.zxy.androiddemo.paging

import com.zxy.androiddemo.db.entries.User

import java.util.ArrayList

/**
 * @author: zxy
 * @date: 2018/7/12
 * @des:
 */
class DataRepository {

    private val list = ArrayList<User>()

    init {

    }


    fun loadData(size: Int): List<User> {
        return list.subList(0, size)
    }

    fun loadData(index: Int, size: Int): List<User>? {
        if (index >= list.size - 1 || index < 1) {
            return null
        }
        if (size + index > list.size) {
            return list.subList(index + 1, list.size)
        }
        return list.subList(index + 1, size + index)
    }

    fun loadPageData(page: Int, size: Int): List<User>? {
        val totalPage = if (list.size % size == 0) {
            list.size / size
        } else {
            list.size / size + 1
        }
        if (page > totalPage || page < 1) {
            return null
        }
        if (page == totalPage) {
            return list.subList((page - 1) * size, list.size)
        }
        return list.subList((page - 1) * size, page * size)
    }

}
