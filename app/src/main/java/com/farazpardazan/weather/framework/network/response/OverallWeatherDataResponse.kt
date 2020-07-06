package com.farazpardazan.weather.framework.network.response

import com.google.gson.annotations.SerializedName

data class OverallWeatherDataResponse(

    @SerializedName("lat")
    val lat: Double,

    @SerializedName("lon")
    val lon: Double,

    @SerializedName("timezone")
    val timezone: String,

    @SerializedName("timezone_offset")
    val timezoneOffset: Int,

    @SerializedName("current")
    val currentResponse: CurrentResponse?,

    @SerializedName("minutely")
    val minutelyResponse: List<MinutelyResponse>?,

    @SerializedName("hourly")
    val hourlyResponse: List<HourlyResponse>?,

    @SerializedName("daily")
    val dailyResponse: List<DailyResponse>?
)