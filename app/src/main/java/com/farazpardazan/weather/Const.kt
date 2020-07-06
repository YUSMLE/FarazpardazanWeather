package com.farazpardazan.weather

object Const {

    // The base URL used for Open Weather API services.
    const val BASE_URL: String = "https://api.openweathermap.org/"

    // The extra URL used for Open Cities API service.
    const val OPEN_CITIES_URL: String = "https://my-json-server.typicode.com/YUSMLE/FarazpardazanWeather/"

    // The API Key required for Open Weather API services.
    const val API_KEY = "5e1e0769cd4f76cb00e9f302c35a69d1"

    // The language specification for Open Weather API services.
    const val LANGUAGE = "en"

    /**
     * For temperature in Fahrenheit, use units=imperial,
     * For temperature in Celsius, use units=metric,
     * Kelvin is used by default, so there is no need to use the units parameter in the API call if you want this.
     */
    const val MEASUREMENT_UNIT = "metric"
}
