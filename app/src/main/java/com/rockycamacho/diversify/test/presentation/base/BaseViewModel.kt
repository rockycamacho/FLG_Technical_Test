package com.rockycamacho.diversify.test.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {
    protected val disposables = CompositeDisposable()

    protected val loadingIndicator = MutableLiveData<Boolean>()

    fun getLoadingIndicator(): LiveData<Boolean> {
        return loadingIndicator
    }

    fun showLoading(showLoading: Boolean) {
        this.loadingIndicator.value = showLoading
    }
}
