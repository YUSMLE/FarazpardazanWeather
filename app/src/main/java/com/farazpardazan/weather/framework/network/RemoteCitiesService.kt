package com.farazpardazan.weather.framework.network

import com.farazpardazan.weather.framework.network.response.cities.CityResponse
import retrofit2.Response
import retrofit2.http.GET

interface RemoteCitiesService {

    @GET("open_cities")
    suspend fun fetchOpenCities(): Response<List<CityResponse>>
}
