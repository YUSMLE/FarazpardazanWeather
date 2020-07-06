package com.farazpardazan.core.domain

data class OverallWeatherData(
    val lat: Double,
    val lon: Double,
    val timezone: String,
    val timezoneOffset: Int,
    val current: Current?,
    val minutely: List<Minutely>?,
    val hourly: List<Hourly>?,
    val daily: List<Daily>?
)