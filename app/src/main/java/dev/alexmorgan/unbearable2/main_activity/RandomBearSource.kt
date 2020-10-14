package dev.alexmorgan.unbearable2.main_activity

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import javax.inject.Inject
import kotlin.random.Random

class RandomBearSource @Inject constructor(
    private val random: Random,
    private val bearNameGenerator: BearNameGenerator
) : BearSource {

    override suspend fun getAllBears(): List<Bear> {
        val bears = mutableListOf<Bear>()
        repeat(random.nextInt(30, 60)) {
            bears.add(
                Bear(
                    bearNameGenerator.randomName(),
                    "https://placebear.com/${random.nextInt(500, 600)}/${random.nextInt(500, 600)}.jpg"
                )
            )
        }
        return bears
    }
}

@Module
@InstallIn(ActivityComponent::class)
interface RandomBearSourceModule {
    @Binds
    fun bindBearSourceModule(source: RandomBearSource): BearSource
}