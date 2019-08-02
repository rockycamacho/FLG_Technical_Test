package com.rockycamacho.diversify.test.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rockycamacho.diversify.test.DiversifyTestApp
import com.rockycamacho.diversify.test.R
import com.rockycamacho.diversify.test.di.AppComponent

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val appComponent = DiversifyTestApp[this].getAppComponent()
        injectDependencies(appComponent)
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
    }

    abstract fun injectDependencies(appComponent: AppComponent)

}
