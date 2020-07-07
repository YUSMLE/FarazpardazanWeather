package com.farazpardazan.weather.framework.network.response.cities

import com.google.gson.annotations.SerializedName

data class CityResponse(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("state")
    val state: String,

    @SerializedName("country")
    val country: String,

    @SerializedName("coord")
    val coordResponse: CoordResponse?
)
