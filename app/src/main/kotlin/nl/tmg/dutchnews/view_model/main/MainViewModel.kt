package nl.tmg.dutchnews.view_model.main

import android.util.Log
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import nl.tmg.dutchnews.model.repository.INewsRepository
import nl.tmg.dutchnews.view_model.BaseViewModel
import nl.tmg.dutchnews.view_model.IBaseViewModel
import javax.inject.Inject

interface IMainViewModelContract : IBaseViewModel {
    fun getTopHeaders()
}

class MainViewModel @Inject constructor(private val newsRepository: INewsRepository) : BaseViewModel(),
    IMainViewModelContract {

    override fun getTopHeaders() {
        compositeDisposable += newsRepository.getTopHeadlines()
            .subscribeBy(
                onSuccess = {
                    Log.d("DutchNews", "some data > ${it[0].description}")
                    Log.d("DutchNews", "some data > ${it[0].publishedAt}")
                },
                onError = {
                    Log.d("DutchNews", "WOW! thats error. check logs")
                }
            )
    }
}
