package com.farazpardazan.weather.framework.database

import android.content.Context
import com.farazpardazan.core.data.CitiesDataSource
import com.farazpardazan.core.domain.Resource
import com.farazpardazan.core.domain.cities.City
import javax.inject.Inject

class LocalCitiesDataSource @Inject constructor(context: Context) : CitiesDataSource {

    override suspend fun getOpenCities(): Resource<List<City>> {
        TODO("Not yet implemented")
    }
}
