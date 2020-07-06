package com.farazpardazan.weather.framework.network

import com.farazpardazan.weather.framework.network.response.OverallWeatherDataResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteWeatherService {

    @GET("data/2.5/onecall")
    suspend fun fetchOverallWeatherData(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double
    ): Response<OverallWeatherDataResponse>
}