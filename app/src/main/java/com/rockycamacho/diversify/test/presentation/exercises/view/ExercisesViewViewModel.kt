package com.rockycamacho.diversify.test.presentation.exercises.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rockycamacho.diversify.test.data.network.models.Exercise
import com.rockycamacho.diversify.test.data.network.models.Muscle
import com.rockycamacho.diversify.test.presentation.base.BaseViewModel
import javax.inject.Inject

class ExercisesViewViewModel @Inject constructor(): BaseViewModel() {

    protected val data = MutableLiveData<Exercise>()

    fun getExercise(): LiveData<Exercise> {
        return data
    }

    fun show(data: Exercise) {
        this.data.value = data
    }

}
