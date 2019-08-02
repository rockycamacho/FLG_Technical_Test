package com.rockycamacho.diversify.test.endtoend

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.rockycamacho.diversify.test.R

class ExerciseViewRobot : BaseTestRobot() {

    fun isShown() {
        onView(ViewMatchers.withId(R.id.exercise_image)).check(matches(isDisplayed()))
        onView(ViewMatchers.withId(R.id.exercise_name)).check(matches(isDisplayed()))
        onView(ViewMatchers.withId(R.id.exercise_description)).check(matches(isDisplayed()))
        onView(ViewMatchers.withId(R.id.list)).check(matches(isDisplayed()))
    }

    fun pressBackButton() {
        pressBack()
    }

    fun goToExerciseList(func: ExerciseListRobot.() -> Unit) = ExerciseListRobot()
        .apply { func() }

}

fun exerciseView(func: ExerciseViewRobot.() -> Unit) = ExerciseViewRobot()
    .apply { func() }