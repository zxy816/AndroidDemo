package com.zxy.androiddemo.http

import com.google.gson.JsonObject

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
        fun getRequestBody(requestCode: String, contentJson: JsonObject): JsonObject {
            val dataMap = JsonObject()
            dataMap.addProperty("apiCode", requestCode)
            dataMap.addProperty("token", "06ec5abaf8b84a58b0922c01e58e75e3")
            dataMap.add("content", contentJson)
            return dataMap
        }
    }
}