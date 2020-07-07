package com.farazpardazan.weather.framework.network.mapper

import com.farazpardazan.core.domain.cities.City
import com.farazpardazan.weather.framework.network.response.cities.CityResponse
import com.farazpardazan.weather.mapper.DataMapper
import javax.inject.Inject

class CityResponseMapper @Inject constructor(
    private val coordResponseMapper: CoordResponseMapper
) : DataMapper<City, CityResponse>() {

    override fun transformToEntity(model: City): CityResponse? {
        // Unnecessary transform
        return null
    }

    override fun transformToModel(entity: CityResponse): City? {
        return City(
            entity.id,
            entity.name,
            entity.state,
            entity.country,
            entity.coordResponse?.let { coordResponseMapper.transformToModel(it) }
        )
    }
}
