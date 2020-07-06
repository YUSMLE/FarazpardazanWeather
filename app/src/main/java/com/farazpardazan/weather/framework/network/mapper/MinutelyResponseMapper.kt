package com.farazpardazan.weather.framework.network.mapper

import com.farazpardazan.core.domain.Minutely
import com.farazpardazan.weather.framework.network.response.MinutelyResponse
import com.farazpardazan.weather.mapper.DataMapper
import javax.inject.Inject

class MinutelyResponseMapper @Inject constructor() : DataMapper<Minutely, MinutelyResponse>() {

    override fun transformToEntity(model: Minutely): MinutelyResponse? {
        // Unnecessary transform
        return null
    }

    override fun transformToModel(entity: MinutelyResponse): Minutely? {
        return Minutely(
            entity.dt,
            entity.precipitation
        )
    }
}