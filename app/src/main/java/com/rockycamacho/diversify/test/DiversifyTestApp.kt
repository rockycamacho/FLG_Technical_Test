package com.rockycamacho.diversify.test

import android.app.Application
import android.content.Context
import com.rockycamacho.diversify.test.di.*
import timber.log.Timber

class DiversifyTestApp : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        buildAppComponent()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun buildAppComponent() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .dataModule(DataModule())
            .networkModule(NetworkModule())
            .apiModule(ApiModule(BuildConfig.API_ENDPOINT))
            .build()
    }

    companion object {
        operator fun get(context: Context): DiversifyTestApp =
            context.applicationContext as DiversifyTestApp
    }
}