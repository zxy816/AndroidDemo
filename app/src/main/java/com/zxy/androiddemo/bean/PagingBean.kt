package com.zxy.androiddemo.bean

import com.google.gson.annotations.SerializedName

data class PagingBean(
        @SerializedName("id") val id: Int,
        @SerializedName("name") val name: String,
        @SerializedName("description") val description: String?,
        @SerializedName("stargazers_count") val starCount: Int
)

class PagingResponse(
        @SerializedName("items") val items: List<PagingBean> = emptyList()
)