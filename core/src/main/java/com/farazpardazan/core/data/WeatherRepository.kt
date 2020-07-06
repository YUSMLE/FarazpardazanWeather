package com.farazpardazan.core.data

import com.farazpardazan.core.domain.OverallWeatherData
import com.farazpardazan.core.domain.Resource
import javax.inject.Inject

class WeatherRepository @Inject constructor (private val dataSource: WeatherDataSource) {

    suspend fun getOverallWeatherData(): Resource<OverallWeatherData> =
        dataSource.getOverallWeatherData()
}
