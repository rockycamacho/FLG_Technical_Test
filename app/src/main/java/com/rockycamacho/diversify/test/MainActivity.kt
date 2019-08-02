package com.rockycamacho.diversify.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rockycamacho.diversify.test.presentation.exercises.list.ExercisesListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(
                    R.id.fragment_container,
                    ExercisesListFragment.newInstance()
                )
                .addToBackStack(ExercisesListFragment::class.java.simpleName)
                .commit()
        }
    }
}
