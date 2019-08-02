package com.rockycamacho.diversify.test.di

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@OpenForTesting
@Module
class AppModule(private val app: Application) {

    @Singleton
    @Provides
    fun application(): Application = app

}
