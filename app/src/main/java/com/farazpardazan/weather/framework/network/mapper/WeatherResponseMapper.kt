package com.farazpardazan.weather.framework.network.mapper

import com.farazpardazan.core.domain.Weather
import com.farazpardazan.weather.framework.network.response.WeatherResponse
import com.farazpardazan.weather.mapper.DataMapper
import javax.inject.Inject

class WeatherResponseMapper @Inject constructor() : DataMapper<Weather, WeatherResponse>() {

    override fun transformToEntity(model: Weather): WeatherResponse? {
        // Unnecessary transform
        return null
    }

    override fun transformToModel(entity: WeatherResponse): Weather? {
        return Weather(
            entity.id,
            entity.main,
            entity.description,
            entity.icon
        )
    }
}