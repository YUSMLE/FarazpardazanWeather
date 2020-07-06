package com.farazpardazan.weather.framework.network.mapper

import com.farazpardazan.core.domain.Current
import com.farazpardazan.weather.framework.network.response.CurrentResponse
import com.farazpardazan.weather.mapper.DataMapper
import javax.inject.Inject

class CurrentResponseMapper @Inject constructor(
    private val weatherResponseMapper: WeatherResponseMapper
) : DataMapper<Current, CurrentResponse>() {

    override fun transformToEntity(model: Current): CurrentResponse? {
        // Unnecessary transform
        return null
    }

    override fun transformToModel(entity: CurrentResponse): Current? {
        return Current(
            entity.dt,
            entity.sunrise,
            entity.sunset,
            entity.temp,
            entity.feelsLike,
            entity.pressure,
            entity.humidity,
            entity.dewPoint,
            entity.uvi,
            entity.clouds,
            entity.visibility,
            entity.windSpeed,
            entity.windDeg,
            entity.weatherResponse?.let { weatherResponseMapper.transformToModels(it) }
        )
    }
}