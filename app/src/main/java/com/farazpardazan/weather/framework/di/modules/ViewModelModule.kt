package com.farazpardazan.weather.framework.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.farazpardazan.weather.common.help.ViewModelFactory
import com.farazpardazan.weather.framework.di.keys.ViewModelKey
import com.farazpardazan.weather.presentation.viewmodel.MainVM
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @IntoMap
    @Binds
    @ViewModelKey(MainVM::class)
    abstract fun provideMainViewModel(mainVM: MainVM): ViewModel
}
