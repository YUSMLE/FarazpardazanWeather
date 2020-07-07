package com.farazpardazan.weather.framework.network.response

import com.google.gson.annotations.SerializedName

data class RainResponse(

    @SerializedName("1h")
    val `1h`: Double
)