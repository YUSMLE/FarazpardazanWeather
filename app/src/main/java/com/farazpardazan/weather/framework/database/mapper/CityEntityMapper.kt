package com.farazpardazan.weather.framework.database.mapper

import com.farazpardazan.core.domain.cities.City
import com.farazpardazan.core.domain.cities.Coord
import com.farazpardazan.weather.framework.database.entity.CityEntity
import com.farazpardazan.weather.mapper.DataMapper
import javax.inject.Inject

class CityEntityMapper @Inject constructor() : DataMapper<City, CityEntity>() {

    override fun transformToEntity(model: City): CityEntity? {
        return CityEntity(
            model.id,
            model.name,
            model.state,
            model.country,
            model.coord?.lon ?: Double.NaN,
            model.coord?.lat ?: Double.NaN
        )
    }

    override fun transformToModel(entity: CityEntity): City? {
        return City(
            entity.id,
            entity.name,
            entity.state,
            entity.country,
            Coord(
                entity.lon,
                entity.lat
            )
        )
    }
}
