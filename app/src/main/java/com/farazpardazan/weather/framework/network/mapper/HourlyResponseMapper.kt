package com.farazpardazan.weather.framework.network.mapper

import com.farazpardazan.core.domain.Hourly
import com.farazpardazan.weather.framework.network.response.HourlyResponse
import com.farazpardazan.weather.mapper.DataMapper
import javax.inject.Inject

class HourlyResponseMapper @Inject constructor(
    private val weatherResponseMapper: WeatherResponseMapper,
    private val rainResponseMapper: RainResponseMapper
) : DataMapper<Hourly, HourlyResponse>() {

    override fun transformToEntity(model: Hourly): HourlyResponse? {
        // Unnecessary transform
        return null
    }

    override fun transformToModel(entity: HourlyResponse): Hourly? {
        return Hourly(
            entity.dt,
            entity.temp,
            entity.feelsLike,
            entity.pressure,
            entity.humidity,
            entity.dewPoint,
            entity.clouds,
            entity.windSpeed,
            entity.windDeg,
            entity.weatherResponse?.let { weatherResponseMapper.transformToModels(it) },
            entity.rainResponse?.let { rainResponseMapper.transformToModel(it) }
        )
    }
}