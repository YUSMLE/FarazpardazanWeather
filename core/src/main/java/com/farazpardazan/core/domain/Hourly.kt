package com.farazpardazan.core.domain

data class Hourly(
    val dt: Int,
    val temp: Double,
    val feels_like: Double,
    val pressure: Int,
    val humidity: Int,
    val dew_point: Double,
    val clouds: Int,
    val wind_speed: Double,
    val wind_deg: Int,
    val weather: List<Weather>,
    val rain: Rain
)