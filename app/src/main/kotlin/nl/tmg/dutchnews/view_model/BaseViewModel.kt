package nl.tmg.dutchnews.view_model

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

interface IBaseViewModel

abstract class BaseViewModel : ViewModel(), IBaseViewModel {

    protected val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}
