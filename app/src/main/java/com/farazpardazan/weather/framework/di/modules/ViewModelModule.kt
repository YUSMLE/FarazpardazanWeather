package com.farazpardazan.weather.framework.di.modules

import androidx.lifecycle.ViewModelProvider
import com.farazpardazan.weather.common.help.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    /*@IntoMap
    @Binds
    @ViewModelKey(MainVM::class)
    abstract fun provideMainViewModel(mainVM: MainVM): ViewModel*/
}
