package com.farazpardazan.weather.framework.network.mapper

import com.farazpardazan.core.domain.cities.Coord
import com.farazpardazan.weather.framework.network.response.cities.CoordResponse
import com.farazpardazan.weather.mapper.DataMapper
import javax.inject.Inject

class CoordResponseMapper @Inject constructor() : DataMapper<Coord, CoordResponse>() {

    override fun transformToEntity(model: Coord): CoordResponse? {
        // Unnecessary transform
        return null
    }

    override fun transformToModel(entity: CoordResponse): Coord? {
        return Coord(
            entity.lon,
            entity.lat
        )
    }
}
