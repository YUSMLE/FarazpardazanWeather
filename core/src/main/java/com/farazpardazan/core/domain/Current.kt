package com.farazpardazan.core.domain

data class Current(
    val dt: Int,
    val sunrise: Int,
    val sunset: Int,
    val temp: Double,
    val feelsLike: Double,
    val pressure: Int,
    val humidity: Int,
    val dewPoint: Double,
    val uvi: Double,
    val clouds: Int,
    val visibility: Int,
    val windSpeed: Double,
    val windDeg: Int,
    val weather: List<Weather>?
)