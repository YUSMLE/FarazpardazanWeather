package com.farazpardazan.weather.framework.network

import android.util.Log
import com.farazpardazan.core.data.WeatherDataSource
import com.farazpardazan.core.domain.OverallWeatherData
import com.farazpardazan.core.domain.Resource
import com.farazpardazan.weather.framework.network.mapper.OverallWeatherDataResponseMapper
import java.io.IOException
import javax.inject.Inject

class RemoteWeatherDataSource @Inject constructor(
    private val service: RemoteWeatherService,
    private val overallWeatherDataResponseMapper: OverallWeatherDataResponseMapper
) : WeatherDataSource {

    override suspend fun getOverallWeatherData(lat: Double, lon:Double): Resource<OverallWeatherData> {
        return try {
            val response = service.fetchOverallWeatherData(lat, lon)
            return if (response.isSuccessful) {
                overallWeatherDataResponseMapper.transformToModel(response.body()!!)?.let {
                    return Resource.success(it)
                } ?: Resource.error(
                    IOException(response.errorBody()?.string() ?: "Something goes wrong")
                )
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
