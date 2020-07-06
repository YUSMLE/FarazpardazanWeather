package com.farazpardazan.weather.framework.network

import android.util.Log
import com.farazpardazan.core.data.CitiesDataSource
import com.farazpardazan.core.domain.Resource
import com.farazpardazan.core.domain.cities.City
import com.farazpardazan.weather.framework.network.mapper.CityResponseMapper
import java.io.IOException
import javax.inject.Inject

class RemoteCitiesDataSource @Inject constructor(
    private val service: RemoteCitiesService,
    private val cityResponseMapper: CityResponseMapper
) : CitiesDataSource {

    override suspend fun getOpenCities(): Resource<List<City>> {
        return try {
            val response = service.fetchOpenCities()
            return if (response.isSuccessful) {
                Resource.success(cityResponseMapper.transformToModels(response.body()!!))
            }
            else {
                /* Handle standard error codes, by checking [response.code()] */

                Resource.error(
                    IOException(response.errorBody()?.string() ?: "Something goes wrong")
                )
            }
        }
        catch (e: Exception) {
            // DEBUG
            Log.e("getOverallWeatherData", e.message ?: "Internet error runs")

            Resource.error(IOException(e.message ?: "Internet error runs"))
        }
    }
}
