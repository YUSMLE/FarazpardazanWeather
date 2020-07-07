package com.farazpardazan.core.data

import com.farazpardazan.core.domain.Resource
import com.farazpardazan.core.domain.Status
import com.farazpardazan.core.domain.cities.City
import javax.inject.Inject
import javax.inject.Named

class CitiesRepository @Inject constructor(
    @Named("local") private val localDataSource: CitiesDataSource,
    @Named("remote") private val remoteDataSource: CitiesDataSource
) {

    suspend fun getOpenCities(): Resource<List<City>> {
        val localResource: Resource<List<City>> = getOpenCitiesFromLocal()

        return if (localResource.status == Status.SUCCESS && localResource.data!!.isNotEmpty()) {
            localResource
        }
        else {
            val remoteResource: Resource<List<City>> = getOpenCitiesFromRemote()

            /* TODO("Store the fetched remote resource in the local data source here") */

            remoteResource
        }
    }

    private suspend fun getOpenCitiesFromLocal(): Resource<List<City>> =
        localDataSource.getOpenCities()

    private suspend fun getOpenCitiesFromRemote(): Resource<List<City>> =
        remoteDataSource.getOpenCities()
}
