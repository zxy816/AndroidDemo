package com.zxy.androiddemo.http

/**
 * @author: zxy
 * @date: 2020/9/9
 * @des:
 */
class HttpRequestBody {
    companion object {
        /**
         * 封装请求体
         */
        fun getRequestBody(requestCode: String, contentMap: HashMap<String, Any>): HashMap<String, Any> {
            val dataMap = HashMap<String, Any>()
            dataMap.put("apiCode", requestCode)
            dataMap.put("token", "RjA6REU6Qjk6MDI6MTY6MjQzMTE1MzA3MTY=")
            dataMap.put("content", contentMap)
            return dataMap
        }
    }
}