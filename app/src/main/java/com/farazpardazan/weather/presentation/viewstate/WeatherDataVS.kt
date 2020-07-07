package com.farazpardazan.weather.presentation.viewstate

import com.farazpardazan.core.domain.OverallWeatherData
import com.farazpardazan.core.domain.Status
import com.farazpardazan.core.domain.cities.City

class WeatherDataVS(
    private val status: Status,
    private val errorMessage: String? = null,
    private val overallWeatherData: OverallWeatherData? = null,
    private val openCities: List<City>? = null,
    private val currentCity: City? = null
) {

    fun isLoadingInitialData() = status == Status.LOADING && openCities == null

    fun isLoadingSequenceData() = status == Status.LOADING && openCities != null

    fun shouldShowErrorAnnounce() = errorMessage != null && openCities == null

    fun shouldShowErrorToast() = errorMessage != null && openCities != null

    fun getErrorMessage() = errorMessage

    fun getOverallWeatherData() = overallWeatherData

    fun getOpenCities() = openCities ?: mutableListOf()

    fun getCurrentCity() = currentCity
}
