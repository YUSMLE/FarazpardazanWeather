package com.farazpardazan.weather.framework.network.mapper

import com.farazpardazan.core.domain.Temp
import com.farazpardazan.weather.framework.network.response.TempResponse
import com.farazpardazan.weather.mapper.DataMapper
import javax.inject.Inject

class TempResponseMapper @Inject constructor() : DataMapper<Temp, TempResponse>() {

    override fun transformToEntity(model: Temp): TempResponse? {
        // Unnecessary transform
        return null
    }

    override fun transformToModel(entity: TempResponse): Temp? {
        return Temp(
            entity.day,
            entity.min,
            entity.max,
            entity.night,
            entity.eve,
            entity.morn
        )
    }
}