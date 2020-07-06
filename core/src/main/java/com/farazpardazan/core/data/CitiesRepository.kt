package com.farazpardazan.core.data

import com.farazpardazan.core.domain.Resource
import com.farazpardazan.core.domain.cities.City
import javax.inject.Inject

class CitiesRepository @Inject constructor(private val dataSource: CitiesDataSource) {

    suspend fun getOpenCities(): Resource<List<City>> =
        dataSource.getOpenCities()
}
