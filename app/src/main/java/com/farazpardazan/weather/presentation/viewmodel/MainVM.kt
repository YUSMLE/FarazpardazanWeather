package com.farazpardazan.weather.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.farazpardazan.core.domain.OverallWeatherData
import com.farazpardazan.core.domain.Resource
import com.farazpardazan.core.domain.Status
import com.farazpardazan.core.domain.cities.City
import com.farazpardazan.core.interactors.OpenCitiesUseCase
import com.farazpardazan.core.interactors.OverallWeatherDataUseCase
import com.farazpardazan.weather.common.help.RxAwareViewModel
import com.farazpardazan.weather.presentation.viewstate.WeatherDataVS
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainVM @Inject constructor(
    private val overallWeatherDataUseCase: OverallWeatherDataUseCase,
    private val openCitiesUseCase: OpenCitiesUseCase
) : RxAwareViewModel() {

    private val weatherDataStream = MutableLiveData<WeatherDataVS>()

    fun fetchOpenCities() {
        viewModelScope.launch(Dispatchers.IO) {
            val resource = openCitiesUseCase.invoke()

            withContext(Dispatchers.Main) {
                weatherDataStream.postValue(buildViewStateWithOpenCities(resource))
            }
        }

        // Dispatch loading view state
        weatherDataStream.postValue(buildLoadingViewState())
    }

    fun fetchOverallWeatherData(lat: Double, lon:Double) {
        viewModelScope.launch {
            val resource = overallWeatherDataUseCase.invoke(lat, lon)

            withContext(Dispatchers.Main) {
                weatherDataStream.postValue(buildViewStateWithOverallWeatherData(resource))
            }
        }

        // Dispatch loading view state
        weatherDataStream.postValue(buildLoadingViewState())
    }

    /**
     * ViewState
     */

    private fun buildViewStateWithOpenCities(
        resource: Resource<List<City>>
    ): WeatherDataVS {
        return WeatherDataVS(
            status = resource.status,
            errorMessage = resource.error?.message,
            openCities = resource.data
        )
    }

    private fun buildViewStateWithOverallWeatherData(
        resource: Resource<OverallWeatherData>
    ): WeatherDataVS {
        return WeatherDataVS(
            status = resource.status,
            errorMessage = resource.error?.message,
            overallWeatherData = resource.data
        )
    }

    private fun buildLoadingViewState(): WeatherDataVS {
        return WeatherDataVS(status = Status.LOADING)
    }

    /**
     * Accessory
     */

    fun getWeatherDataStream(): LiveData<WeatherDataVS> = weatherDataStream

    fun setCurrentCity(city: City) {
        TODO("Not yet implemented")
    }
}
