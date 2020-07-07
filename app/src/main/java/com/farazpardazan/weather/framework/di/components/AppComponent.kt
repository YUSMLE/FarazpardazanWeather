package com.farazpardazan.weather.framework.di.components

import android.app.Application
import com.farazpardazan.weather.App
import com.farazpardazan.weather.framework.di.modules.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuilderModule::class,
        FragmentBuilderModule::class,
        ViewModelModule::class,
        DataSourceModule::class,
        ContextModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun app(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}
