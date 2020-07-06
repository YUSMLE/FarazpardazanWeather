package com.farazpardazan.weather.framework.network

import com.farazpardazan.weather.Const
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RequestInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        val httpUrl = request.url.newBuilder()
            .addQueryParameter(API_KEY_QUERY, API_KEY_VALUE)
            .addQueryParameter(LANGUAGE_QUERY, LANGUAGE_VALUE)
            .addQueryParameter(MEASUREMENT_UNIT_QUERY, MEASUREMENT_UNIT_VALUE)
            .build()

        request = request.newBuilder().url(httpUrl).build()

        return chain.proceed(request)
    }

    companion object {
        const val API_KEY_QUERY = "appid"
        const val API_KEY_VALUE = Const.API_KEY
        const val LANGUAGE_QUERY = "lang"
        const val LANGUAGE_VALUE = Const.LANGUAGE
        const val MEASUREMENT_UNIT_QUERY = "units"
        const val MEASUREMENT_UNIT_VALUE = Const.MEASUREMENT_UNIT
    }
}
