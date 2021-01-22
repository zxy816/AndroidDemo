package com.zxy.androiddemo.http

import com.google.gson.JsonArray
import com.google.gson.JsonObject

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
        fun getPagingData(nextPageNumber: Int): JsonObject {
            val contentJson = JsonObject()
            contentJson.addProperty("startDate", "020-08-10")
            contentJson.addProperty("endDate", "2020-09-08")
            contentJson.addProperty("status", "")
            contentJson.addProperty("startIndex", nextPageNumber)
            contentJson.addProperty("size", 10)
            contentJson.addProperty("userId", "668")
            contentJson.addProperty("macCode", "F0:DE:B9:02:16:24")
            return HttpRequestBody.getRequestBody("100907", contentJson)
        }

        fun lotteryBet(): JsonObject {
            val contentJson = JsonObject()
            contentJson.addProperty("gameId", "10")
            contentJson.addProperty("tickSn", "null")
            contentJson.addProperty("stationId", "")
            contentJson.addProperty("memberId", "0")
            contentJson.addProperty("bankId", "0001")
            contentJson.addProperty("cardId", "6228480402564890018")
            contentJson.addProperty("macCode", "F0:DE:B9:02:16:24")
            contentJson.addProperty("password", "")
            contentJson.addProperty("staffId", "0")
            contentJson.addProperty("id", "450")
            contentJson.addProperty("userId", "450")
            contentJson.addProperty("timeStamp", "")
            contentJson.addProperty("betCount", "")
            contentJson.addProperty("timeStamp", "1")
            contentJson.addProperty("issue", "")
            contentJson.addProperty("multiIssueCount", "1")
            contentJson.addProperty("ticketMoney", "2.0")
            val arrayJson = JsonArray()
            // 循环一次（不包含 1）
            for (i in 0 until 1) {
                val betJson = JsonObject()
                betJson.addProperty("betSn", "1")
                betJson.addProperty("betMode", "1")
                betJson.addProperty("playType", "1/9")
                betJson.addProperty("betMulti", 1)
                betJson.addProperty("betNumbers", "8|70|")
                arrayJson.add(betJson)
            }
            contentJson.add("betList", arrayJson)
            return HttpRequestBody.getRequestBody("100903", contentJson)
        }
    }
}