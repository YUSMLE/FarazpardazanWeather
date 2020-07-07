package com.farazpardazan.weather.presentation.view.di

import androidx.fragment.app.FragmentManager
import com.farazpardazan.weather.framework.di.scopes.ActivityScope
import com.farazpardazan.weather.presentation.view.ui.MainActivity
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule() {

    @Provides
    @ActivityScope
    fun provideFragmentManager(activity: MainActivity): FragmentManager {
        return activity.supportFragmentManager
    }

    /* TODO("Provide other activity dependencies here") */
}
