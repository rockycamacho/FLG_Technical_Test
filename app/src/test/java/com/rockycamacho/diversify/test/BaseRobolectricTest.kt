package com.rockycamacho.diversify.test

import android.os.Build
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@Config(
    sdk = [
        //Uncomment build versions to test on other sdks
//        Build.VERSION_CODES.P,
//        Build.VERSION_CODES.O,
//        Build.VERSION_CODES.N,
//        Build.VERSION_CODES.M,
        Build.VERSION_CODES.LOLLIPOP
    ]
)
@RunWith(AndroidJUnit4::class)
abstract class BaseRobolectricTest : BaseInjectedTest() {

    protected lateinit var activityScenario: ActivityScenario<MainActivity>

    @Before
    fun setup() {
        activityScenario = ActivityScenario.launch(MainActivity::class.java)
    }

}
