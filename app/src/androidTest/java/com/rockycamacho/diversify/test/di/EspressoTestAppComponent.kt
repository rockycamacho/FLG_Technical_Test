package com.rockycamacho.diversify.test.di

import com.rockycamacho.diversify.test.endtoend.ViewExerciseTest
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        EspressoAppModule::class,
        DataModule::class,
        NetworkModule::class,
        ApiModule::class
    ]
)
interface EspressoTestAppComponent : AppComponent {
    fun inject(test: ViewExerciseTest)


}
