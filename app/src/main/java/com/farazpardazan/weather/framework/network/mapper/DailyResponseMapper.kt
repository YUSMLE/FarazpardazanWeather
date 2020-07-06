package com.farazpardazan.weather.framework.network.mapper

import com.farazpardazan.core.domain.Daily
import com.farazpardazan.weather.framework.network.response.DailyResponse
import com.farazpardazan.weather.mapper.DataMapper
import javax.inject.Inject

class DailyResponseMapper @Inject constructor(
    private val tempResponseMapper: TempResponseMapper,
    private val feelsLikeResponseMapper: FeelsLikeResponseMapper,
    private val weatherResponseMapper: WeatherResponseMapper
) : DataMapper<Daily, DailyResponse>() {

    override fun transformToEntity(model: Daily): DailyResponse? {
        // Unnecessary transform
        return null
    }

    override fun transformToModel(entity: DailyResponse): Daily? {
        return Daily(
            entity.dt,
            entity.sunrise,
            entity.sunset,
            entity.tempResponse?.let { tempResponseMapper.transformToModel(it) },
            entity.feelsLikeResponse?.let { feelsLikeResponseMapper.transformToModel(it) },
            entity.pressure,
            entity.humidity,
            entity.dewPoint,
            entity.windSpeed,
            entity.windDeg,
            entity.weatherResponse?.let { weatherResponseMapper.transformToModels(it) },
            entity.clouds,
            entity.rain,
            entity.uvi
        )
    }
}