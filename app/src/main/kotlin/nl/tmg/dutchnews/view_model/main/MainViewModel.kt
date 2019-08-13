package nl.tmg.dutchnews.view_model.main

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import nl.tmg.dutchnews.model.api.NewsApiService
import nl.tmg.dutchnews.view_model.BaseViewModel
import nl.tmg.dutchnews.view_model.IBaseViewModel
import javax.inject.Inject

interface IMainViewModelContract : IBaseViewModel {
    fun getTopHeaders()
}

class MainViewModel @Inject constructor(private val apiService: NewsApiService) : BaseViewModel(),
    IMainViewModelContract {

    override fun getTopHeaders() {
        val disposable = apiService.getTopHeadlines()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onComplete = {
                    Log.d("DutchNews", "check retrofit logs")
                },
                onError = {
                    Log.d("DutchNews", "WOW! thats error. check logs")
                }
            )
    }
}
