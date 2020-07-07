package com.farazpardazan.weather.framework.network.response

import com.google.gson.annotations.SerializedName

data class FeelsLikeResponse(

    @SerializedName("day")
    val day: Double,

    @SerializedName("night")
    val night: Double,

    @SerializedName("eve")
    val eve: Double,

    @SerializedName("morn")
    val morn: Double
)