package com.farazpardazan.weather.framework.database

import android.util.Log
import com.farazpardazan.core.data.CitiesDataSource
import com.farazpardazan.core.domain.Resource
import com.farazpardazan.core.domain.cities.City
import com.farazpardazan.weather.framework.database.dao.CityDao
import com.farazpardazan.weather.framework.database.mapper.CityEntityMapper
import java.io.IOException
import javax.inject.Inject

class LocalCitiesDataSource @Inject constructor(
    private val cityDao: CityDao,
    private val cityEntityMapper: CityEntityMapper
) : CitiesDataSource {

    override suspend fun getOpenCities(): Resource<List<City>> {
        return try {
            val response = cityDao.find()
            return if (response.isNotEmpty()) {
                Resource.success(cityEntityMapper.transformToModels(response))
            }
            else {
                /* Handle standard error codes, by checking [response.code()] */

                Resource.error(
                    IOException("Something goes wrong")
                )
            }
        }
        catch (e: Exception) {
            // DEBUG
            Log.e("getOpenCities", "Local database error runs")

            Resource.error(IOException(e.message ?: "Local database error runs"))
        }
    }
}
