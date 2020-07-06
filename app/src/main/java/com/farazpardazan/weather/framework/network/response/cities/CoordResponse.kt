package com.farazpardazan.weather.framework.network.response.cities

import com.google.gson.annotations.SerializedName

data class CoordResponse(
    @SerializedName("lon")
    val lon: Double,

    @SerializedName("lat")
    val lat: Double
)
