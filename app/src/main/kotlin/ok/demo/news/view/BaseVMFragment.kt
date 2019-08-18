package ok.demo.news.view

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import ok.demo.news.view_model.BaseViewModel
import ok.demo.news.view_model.IBaseViewModel
import javax.inject.Inject

abstract class BaseVMFragment<T : IBaseViewModel, Router> : BaseInjectionFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Suppress("UNCHECKED_CAST")
    val router: Router by lazy { requireActivity() as Router }

    protected abstract val modelClass: Class<out BaseViewModel>
    /**
     * Defines the scope of view model
     * True - ActivityScope
     * False - FragmentScope
     */
    protected abstract val activityScope: ViewModelScope

    protected val viewModel: T by lazy { obtainViewModel(modelClass) }

    @Suppress("UNCHECKED_CAST")
    private fun obtainViewModel(modelClass: Class<out BaseViewModel>): T {
        return when (activityScope) {
            ViewModelScope.ACTIVITY -> ViewModelProviders.of(requireActivity(), viewModelFactory).get(modelClass) as T
            ViewModelScope.FRAGMENT -> ViewModelProviders.of(this, viewModelFactory).get(modelClass) as T
        }
    }

    protected enum class ViewModelScope {
        ACTIVITY,
        FRAGMENT
    }
}
