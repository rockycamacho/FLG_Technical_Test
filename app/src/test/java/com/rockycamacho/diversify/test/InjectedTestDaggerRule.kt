package com.rockycamacho.diversify.test

import android.os.AsyncTask
import com.rockycamacho.diversify.test.di.TestComponent
import com.rockycamacho.diversify.test.di.ApiModule
import com.rockycamacho.diversify.test.di.DataModule
import com.rockycamacho.diversify.test.di.TestModule
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import it.cosenonjaviste.daggermock.DaggerMockRule

class InjectedTestDaggerRule(test: BaseInjectedTest) : DaggerMockRule<TestComponent>(
    TestComponent::class.java,
    TestModule(),
    DataModule(),
    ApiModule(BuildConfig.API_ENDPOINT)
) {

    init {
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }

        set { component ->
            test.injectDependencies(component)
        }
    }
}
