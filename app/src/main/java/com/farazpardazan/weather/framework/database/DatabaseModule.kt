package com.farazpardazan.weather.framework.database

import android.content.Context
import com.farazpardazan.weather.framework.database.dao.CityDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideLocalCitiesService(context: Context): CityDao {
        return MyDatabase.getInstance(context).cityDao
    }
}
