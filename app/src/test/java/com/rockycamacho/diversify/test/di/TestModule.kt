package com.rockycamacho.diversify.test.di

import com.github.javafaker.Faker
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@OpenForTesting
@Module
class TestModule {

    @Singleton
    @Provides
    fun faker(): Faker = Faker()

}
