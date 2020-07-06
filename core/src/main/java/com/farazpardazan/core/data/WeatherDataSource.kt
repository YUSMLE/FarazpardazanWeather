package com.farazpardazan.core.data

import com.farazpardazan.core.domain.OverallWeatherData
import com.farazpardazan.core.domain.Resource

interface WeatherDataSource {

    suspend fun getOverallWeatherData(): Resource<OverallWeatherData>
}
