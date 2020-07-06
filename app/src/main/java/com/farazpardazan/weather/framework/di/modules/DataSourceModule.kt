package  com.farazpardazan.weather.framework.di.modules

import android.content.Context
import com.farazpardazan.core.data.CitiesDataSource
import com.farazpardazan.core.data.WeatherDataSource
import com.farazpardazan.weather.framework.database.DatabaseModule
import com.farazpardazan.weather.framework.database.LocalCitiesDataSource
import com.farazpardazan.weather.framework.network.*
import com.farazpardazan.weather.framework.network.mapper.CityResponseMapper
import com.farazpardazan.weather.framework.network.mapper.OverallWeatherDataResponseMapper
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [DatabaseModule::class, NetworkModule::class])
class DataSourceModule {

    @Provides
    @Singleton
    fun provideRemoteWeatherDataSource(
        service: RemoteWeatherService,
        overallWeatherDataResponseMapper: OverallWeatherDataResponseMapper
    ): WeatherDataSource {
        return RemoteWeatherDataSource(service, overallWeatherDataResponseMapper)
    }

    @Provides
    @Singleton
    @Named("remote")
    fun provideRemoteCitiesDataSource(
        service: RemoteCitiesService,
        cityResponseMapper: CityResponseMapper
    ): CitiesDataSource {
        return RemoteCitiesDataSource(service, cityResponseMapper)
    }

    @Provides
    @Singleton
    @Named("local")
    fun provideLocalCitiesDataSource(
        context: Context
    ): CitiesDataSource {
        return LocalCitiesDataSource(context)
    }
}
