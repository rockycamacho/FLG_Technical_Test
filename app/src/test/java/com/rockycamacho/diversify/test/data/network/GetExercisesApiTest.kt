package com.rockycamacho.diversify.test.data.network

import com.rockycamacho.diversify.test.BaseInjectedTest
import com.rockycamacho.diversify.test.di.TestComponent
import org.junit.Test
import javax.inject.Inject

class GetExercisesApiTest: BaseInjectedTest() {
    @Inject
    lateinit var apiService: ApiService

    override fun injectDependencies(testComponent: TestComponent) {
        testComponent.inject(this)
    }

    @Test
    fun getExercises_Success() {
        apiService.getExercises()
            .test()
            .assertNoErrors()
            .assertComplete()
    }
}