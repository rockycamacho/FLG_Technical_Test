package com.rockycamacho.diversify.test

import com.rockycamacho.diversify.test.di.TestComponent
import com.rockycamacho.diversify.test.di.ApiModule
import com.rockycamacho.diversify.test.di.DataModule
import com.rockycamacho.diversify.test.di.TestModule
import it.cosenonjaviste.daggermock.DaggerMockRule

class InjectedTestDaggerRule(test: BaseInjectedTest) : DaggerMockRule<TestComponent>(
    TestComponent::class.java,
    TestModule(),
    DataModule(),
    ApiModule(BuildConfig.API_ENDPOINT)
) {

    init {
        set { component ->
            test.injectDependencies(component)
        }
    }
}
