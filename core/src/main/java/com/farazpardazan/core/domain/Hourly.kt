package com.farazpardazan.core.domain

data class Hourly(
    val dt: Int,
    val temp: Double,
    val feelsLike: Double,
    val pressure: Int,
    val humidity: Int,
    val dewPoint: Double,
    val clouds: Int,
    val windSpeed: Double,
    val windDeg: Int,
    val weather: List<Weather>?,
    val rain: Rain?
)