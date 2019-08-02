package com.rockycamacho.diversify.test.presentation.exercises.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rockycamacho.diversify.test.data.network.ApiService
import com.rockycamacho.diversify.test.data.network.models.Exercise
import com.rockycamacho.diversify.test.presentation.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class ExercisesListViewModel @Inject constructor(val apiService: ApiService) : BaseViewModel() {

    protected val data = MutableLiveData<List<Exercise>>()
    protected val errorMessage = MutableLiveData<String>()

    fun fetchData() {
        apiService.getExercises()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { showLoading(true) }
            .doOnTerminate { showLoading(false) }
            .subscribe({ data ->
                show(data)
                showError("")
            }, { e ->
                e.message?.let { showError(it) }
                Timber.e(e)
            })
    }

    fun getData(): LiveData<List<Exercise>> {
        return data
    }

    fun show(data: List<Exercise>) {
        this.data.value = data
    }

    fun getErrorMessage(): LiveData<String> {
        return errorMessage
    }

    fun showError(error: String) {
        this.errorMessage.value = error
    }


}