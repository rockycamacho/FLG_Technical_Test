package com.rockycamacho.diversify.test.endtoend

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.rockycamacho.diversify.test.R

class ExerciseListRobot : BaseTestRobot() {

    fun isShown() {
        onView(ViewMatchers.withId(R.id.list)).check(matches(isDisplayed()))
    }

    fun clickItem(position: Int) {
        clickListItem(R.id.list, position)
    }

    fun goToExerciseView(func: ExerciseViewRobot.() -> Unit): ExerciseViewRobot {
        return exerciseView(func)
    }

}

fun exerciseList(func: ExerciseListRobot.() -> Unit) = ExerciseListRobot()
    .apply { func() }