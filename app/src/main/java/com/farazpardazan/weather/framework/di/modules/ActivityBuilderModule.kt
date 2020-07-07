package com.farazpardazan.weather.framework.di.modules

import com.farazpardazan.weather.framework.di.scopes.ActivityScope
import com.farazpardazan.weather.presentation.view.di.MainActivityModule
import com.farazpardazan.weather.presentation.view.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity
}
