package com.zxy.androiddemo.bean

/**
 * @author: zxy
 * @date: 2021/1/19
 * @des:
 */
data class YouDaoResult(val type: String, val elapsedTime: Int, val translateResult: List<List<TranslateResult>>) {
    data class TranslateResult(val src: String, val tgt: String)
}