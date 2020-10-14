package dev.alexmorgan.unbearable2.main_activity

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlin.random.Random

@Module
@InstallIn(SingletonComponent::class)
class RandomModule {
    @Provides
    fun provideRandom(): Random = Random.Default
}