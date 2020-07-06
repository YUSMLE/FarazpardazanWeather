package com.farazpardazan.core.interactors

import com.farazpardazan.core.data.CitiesRepository
import com.farazpardazan.core.domain.Resource
import com.farazpardazan.core.domain.cities.City
import javax.inject.Inject

class OpenCitiesUseCase @Inject constructor(private val citiesRepository: CitiesRepository) {

    suspend operator fun invoke(): Resource<List<City>> =
        citiesRepository.getOpenCities()
}
