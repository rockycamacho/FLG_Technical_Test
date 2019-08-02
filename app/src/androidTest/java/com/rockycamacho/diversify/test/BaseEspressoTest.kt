package com.rockycamacho.diversify.test

import androidx.test.rule.ActivityTestRule
import com.github.javafaker.Faker
import com.rockycamacho.diversify.test.di.EspressoTestAppComponent
import org.junit.Rule
import javax.inject.Inject

abstract class BaseEspressoTest : BaseTest() {

    @Rule
    @JvmField
    var daggerRule = InjectedEspressoTestDaggerRule(this)

    @Inject
    protected lateinit var faker: Faker

    abstract fun injectDependencies(testComponent: EspressoTestAppComponent)

    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule(MainActivity::class.java, false, false)


}