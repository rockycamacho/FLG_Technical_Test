package com.rockycamacho.diversify.test

import android.os.AsyncTask
import androidx.test.platform.app.InstrumentationRegistry
import com.rockycamacho.diversify.test.di.ApiModule
import com.rockycamacho.diversify.test.di.DataModule
import com.rockycamacho.diversify.test.di.EspressoAppModule
import com.rockycamacho.diversify.test.di.EspressoTestAppComponent
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import it.cosenonjaviste.daggermock.DaggerMockRule

class InjectedEspressoTestDaggerRule(test: BaseEspressoTest) :
    DaggerMockRule<EspressoTestAppComponent>(
        EspressoTestAppComponent::class.java, EspressoAppModule(application),
        DataModule(),
        ApiModule(BuildConfig.API_ENDPOINT)
    ) {

    init {
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.from(AsyncTask.THREAD_POOL_EXECUTOR) }
        set { component ->
            val application = application
            application.setAppComponent(component)
            test.injectDependencies(component)
        }
    }

    companion object {

        protected val application: DiversifyTestApp
            get() =
                InstrumentationRegistry.getInstrumentation().targetContext.applicationContext as DiversifyTestApp
    }
}
