package com.farazpardazan.core.domain

data class Daily(
    val dt: Int,
    val sunrise: Int,
    val sunset: Int,
    val temp: Temp?,
    val feelsLike: FeelsLike?,
    val pressure: Int,
    val humidity: Int,
    val dewPoint: Double,
    val windSpeed: Double,
    val windDeg: Int,
    val weather: List<Weather>?,
    val clouds: Int,
    val rain: Double,
    val uvi: Double
)