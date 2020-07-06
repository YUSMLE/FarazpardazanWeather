package com.farazpardazan.weather.framework.network.response

import com.google.gson.annotations.SerializedName

data class MinutelyResponse(
    @SerializedName("dt")
    val dt: Int,

    @SerializedName("precipitation")
    val precipitation: Int
)