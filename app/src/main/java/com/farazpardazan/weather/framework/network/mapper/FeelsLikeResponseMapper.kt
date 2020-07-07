package com.farazpardazan.weather.framework.network.mapper

import com.farazpardazan.core.domain.FeelsLike
import com.farazpardazan.weather.framework.network.response.FeelsLikeResponse
import com.farazpardazan.weather.mapper.DataMapper
import javax.inject.Inject

class FeelsLikeResponseMapper @Inject constructor() : DataMapper<FeelsLike, FeelsLikeResponse>() {

    override fun transformToEntity(model: FeelsLike): FeelsLikeResponse? {
        // Unnecessary transform
        return null
    }

    override fun transformToModel(entity: FeelsLikeResponse): FeelsLike? {
        return FeelsLike(
            entity.day,
            entity.night,
            entity.eve,
            entity.morn
        )
    }
}