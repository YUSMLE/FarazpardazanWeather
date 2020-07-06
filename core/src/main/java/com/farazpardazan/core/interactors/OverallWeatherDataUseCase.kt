package com.farazpardazan.core.interactors

import com.farazpardazan.core.data.WeatherRepository
import com.farazpardazan.core.domain.OverallWeatherData
import com.farazpardazan.core.domain.Resource
import javax.inject.Inject

class OverallWeatherDataUseCase @Inject constructor(private val weatherRepository: WeatherRepository) {

    suspend operator fun invoke(): Resource<OverallWeatherData> =
        weatherRepository.getOverallWeatherData()
}
