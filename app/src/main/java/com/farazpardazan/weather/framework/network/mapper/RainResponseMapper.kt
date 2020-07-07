package com.farazpardazan.weather.framework.network.mapper

import com.farazpardazan.core.domain.Rain
import com.farazpardazan.weather.framework.network.response.RainResponse
import com.farazpardazan.weather.mapper.DataMapper
import javax.inject.Inject

class RainResponseMapper @Inject constructor() : DataMapper<Rain, RainResponse>() {

    override fun transformToEntity(model: Rain): RainResponse? {
        // Unnecessary transform
        return null
    }

    override fun transformToModel(entity: RainResponse): Rain? {
        return Rain(
            entity.`1h`
        )
    }
}