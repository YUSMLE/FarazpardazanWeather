package com.farazpardazan.core.data

import com.farazpardazan.core.domain.Resource
import com.farazpardazan.core.domain.cities.City

interface CitiesDataSource {

    suspend fun getOpenCities(): Resource<List<City>>
}
