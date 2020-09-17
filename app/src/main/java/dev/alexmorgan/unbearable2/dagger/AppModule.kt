package dev.alexmorgan.unbearable2.dagger

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
interface AppModule {
    @Binds
    fun bindProvidingViewModelFactory(factory: ProvidingViewModelFactory): ViewModelProvider.Factory
}