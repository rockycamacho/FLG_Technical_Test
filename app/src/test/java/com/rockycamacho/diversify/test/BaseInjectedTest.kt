package com.rockycamacho.diversify.test

import com.rockycamacho.diversify.test.di.TestComponent
import com.github.javafaker.Faker
import org.junit.Rule
import javax.inject.Inject

abstract class BaseInjectedTest : BaseTest() {

    @Rule
    @JvmField
    var daggerRule = InjectedTestDaggerRule(this)

    @Inject
    protected lateinit var faker: Faker

    abstract fun injectDependencies(testComponent: TestComponent)
}