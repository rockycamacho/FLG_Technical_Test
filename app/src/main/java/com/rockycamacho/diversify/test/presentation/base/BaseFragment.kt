package com.rockycamacho.diversify.test.presentation.base

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.rockycamacho.diversify.test.DiversifyTestApp
import com.rockycamacho.diversify.test.di.AppComponent
import com.rockycamacho.diversify.test.presentation.ViewModelFactory
import javax.inject.Inject

abstract class BaseFragment<VM : BaseViewModel> : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<VM>
    var progressDialog: ProgressDialog? = null
    lateinit var viewModel: VM

    abstract fun injectDependencies(appComponent: AppComponent)

    abstract fun getLayoutResId(): Int

    override fun onAttach(context: Context) {
        val appComponent = DiversifyTestApp[context].getAppComponent()
        injectDependencies(appComponent)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModelClass())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutResId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViewModel()

    }

    protected abstract fun getViewModelClass(): Class<VM>

    protected fun bindViewModel() {
        viewModel.getLoadingIndicator()
            .observe(this, Observer { showLoadingIndicator(it) })
    }

    private fun showLoadingIndicator(shouldShowLoadingIndicator: Boolean?) {
        if (shouldShowLoadingIndicator != null && shouldShowLoadingIndicator) {
            showProgressDialog()
        } else {
            hideProgressDialog()
        }
    }

    protected fun showProgressDialog() {
        if (progressDialog == null && activity != null) {
            progressDialog = ProgressDialog.show(activity, null, "Please wait...", false, false)

        }
    }

    protected fun hideProgressDialog() {
        progressDialog?.let {
            progressDialog?.dismiss()
            progressDialog = null
        }
    }
}
