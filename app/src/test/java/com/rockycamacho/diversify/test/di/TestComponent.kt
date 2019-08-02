package com.rockycamacho.diversify.test.di

import com.rockycamacho.diversify.test.data.network.GetExercisesApiTest
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    TestModule::class,
    DataModule::class,
    NetworkModule::class,
    ApiModule::class
])
interface TestComponent {
    fun inject(test: GetExercisesApiTest)

}