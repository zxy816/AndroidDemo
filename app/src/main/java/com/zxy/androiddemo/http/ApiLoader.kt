package com.zxy.androiddemo.http

/**
 * @author: zxy
 * @date: 2020/9/9
 * @des:
 */
class ApiLoader {
    companion object {
        /**
         * 网络请求分页数据测试
         */
        fun getPagingData(nextPageNumber: Int): HashMap<String, Any> {
            val map = HashMap<String, Any>();
            map.put("startDate", "020-08-10")
            map.put("endDate", "2020-09-08")
            map.put("status", "")
            map.put("startIndex", nextPageNumber)
            map.put("size", 10)
            map.put("userId", "668")
            map.put("macCode", "F0:DE:B9:02:16:24")
            return HttpRequestBody.getRequestBody("100907", map)
        }
    }
}