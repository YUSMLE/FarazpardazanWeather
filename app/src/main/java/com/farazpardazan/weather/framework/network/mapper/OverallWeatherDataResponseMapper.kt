package com.farazpardazan.weather.framework.network.mapper

import com.farazpardazan.core.domain.OverallWeatherData
import com.farazpardazan.weather.framework.network.response.OverallWeatherDataResponse
import com.farazpardazan.weather.mapper.DataMapper
import javax.inject.Inject

class OverallWeatherDataResponseMapper @Inject constructor(
    private val currentResponseMapper: CurrentResponseMapper,
    private val minutelyResponseMapper: MinutelyResponseMapper,
    private val hourlyResponseMapper: HourlyResponseMapper,
    private val dailyResponseMapper: DailyResponseMapper
) : DataMapper<OverallWeatherData, OverallWeatherDataResponse>() {

    override fun transformToEntity(model: OverallWeatherData): OverallWeatherDataResponse? {
        // Unnecessary transform
        return null
    }

    override fun transformToModel(entity: OverallWeatherDataResponse): OverallWeatherData? {
        return OverallWeatherData(
            entity.lat,
            entity.lon,
            entity.timezone,
            entity.timezoneOffset,
            entity.currentResponse?.let { currentResponseMapper.transformToModel(it) },
            entity.minutelyResponse?.let { minutelyResponseMapper.transformToModels(it) },
            entity.hourlyResponse?.let { hourlyResponseMapper.transformToModels(it) },
            entity.dailyResponse?.let { dailyResponseMapper.transformToModels(it) }
        )
    }
}