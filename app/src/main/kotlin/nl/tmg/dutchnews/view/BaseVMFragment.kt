package nl.tmg.dutchnews.view

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import nl.tmg.dutchnews.view_model.BaseViewModel
import nl.tmg.dutchnews.view_model.IBaseViewModel
import javax.inject.Inject

abstract class BaseVMFragment<T : IBaseViewModel> : BaseInjectionFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected abstract val modelClass: Class<out BaseViewModel>

    protected val viewModel: T by lazy { obtainViewModel(modelClass) }

    @Suppress("UNCHECKED_CAST")
    private fun obtainViewModel(modelClass: Class<out BaseViewModel>): T {
        return ViewModelProviders.of(this, viewModelFactory).get(modelClass) as T
    }
}
