package com.farazpardazan.weather.framework.network.response

import com.google.gson.annotations.SerializedName

data class DailyResponse(
    @SerializedName("dt")
    val dt: Int,

    @SerializedName("sunrise")
    val sunrise: Int,

    @SerializedName("sunset")
    val sunset: Int,

    @SerializedName("temp")
    val tempResponse: TempResponse?,

    @SerializedName("feels_like")
    val feelsLikeResponse: FeelsLikeResponse?,

    @SerializedName("pressure")
    val pressure: Int,

    @SerializedName("humidity")
    val humidity: Int,

    @SerializedName("dew_point")
    val dewPoint: Double,

    @SerializedName("wind_speed")
    val windSpeed: Double,

    @SerializedName("wind_deg")
    val windDeg: Int,

    @SerializedName("weather")
    val weatherResponse: List<WeatherResponse>?,

    @SerializedName("clouds")
    val clouds: Int,

    @SerializedName("rain")
    val rain: Double,

    @SerializedName("uvi")
    val uvi: Double
)