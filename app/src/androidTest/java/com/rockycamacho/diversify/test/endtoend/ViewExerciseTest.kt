package com.rockycamacho.diversify.test.endtoend

import com.rockycamacho.diversify.test.BaseEspressoTest
import com.rockycamacho.diversify.test.di.EspressoTestAppComponent
import org.junit.Test

class ViewExerciseTest : BaseEspressoTest() {
    override fun injectDependencies(testComponent: EspressoTestAppComponent) {
        testComponent.inject(this)
    }

    @Test
    fun clickingItemInListExercise_GoToViewExercise() {
        activityTestRule.launchActivity(null)
        exerciseList {
            isShown()
            clickItem(0)
        }.goToExerciseView {
            isShown()
        }
    }

    @Test
    fun pressingBackFromViewExercise_GoBackToListExercise() {
        activityTestRule.launchActivity(null)
        exerciseList {
            isShown()
            clickItem(0)
        }.goToExerciseView {
            isShown()
            pressBackButton()
        }.goToExerciseList {
            isShown()
        }
    }


}