package com.rockycamacho.diversify.test.di

import com.rockycamacho.diversify.test.data.network.GetExercisesApiTest
import com.rockycamacho.diversify.test.presentation.exercises.list.ExercisesListViewModelTest
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
    fun inject(test: ExercisesListViewModelTest)

}