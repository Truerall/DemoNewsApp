package ok.demo.news.view

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import ok.demo.news.view_model.BaseViewModel
import ok.demo.news.view_model.IBaseViewModel
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
