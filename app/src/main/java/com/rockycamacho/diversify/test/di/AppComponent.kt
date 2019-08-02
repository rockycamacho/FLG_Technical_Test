package com.rockycamacho.diversify.test.di

import com.rockycamacho.diversify.test.presentation.exercises.list.ExercisesListFragment
import com.rockycamacho.diversify.test.presentation.exercises.view.ExercisesViewFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    DataModule::class,
    NetworkModule::class,
    ApiModule::class
])
interface AppComponent {
    fun inject(fragment: ExercisesListFragment)
    fun inject(fragment: ExercisesViewFragment)
}
