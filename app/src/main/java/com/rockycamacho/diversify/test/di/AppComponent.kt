package com.rockycamacho.diversify.test.di

import dagger.Component

@Component(modules = [
    AppModule::class,
    DataModule::class,
    NetworkModule::class,
    ApiModule::class
])
interface AppComponent {



}
