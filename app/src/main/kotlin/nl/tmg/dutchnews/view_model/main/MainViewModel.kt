package nl.tmg.dutchnews.view_model.main

import android.util.Log
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import nl.tmg.dutchnews.model.data_models.Article
import nl.tmg.dutchnews.model.repository.INewsRepository
import nl.tmg.dutchnews.utils.architecture.Event
import nl.tmg.dutchnews.utils.architecture.EventLiveData
import nl.tmg.dutchnews.utils.architecture.NonNullMutableLiveData
import nl.tmg.dutchnews.view_model.BaseViewModel
import nl.tmg.dutchnews.view_model.IBaseViewModel
import javax.inject.Inject

interface IMainViewModelContract : IBaseViewModel {
    val errorEventLiveData: EventLiveData<String>
    val topHeadersLiveData: NonNullMutableLiveData<List<Article>>
    fun getTopHeaders()
}

class MainViewModel @Inject constructor(private val newsRepository: INewsRepository) : BaseViewModel(),
    IMainViewModelContract {

    override val errorEventLiveData = EventLiveData<String>()
    override val topHeadersLiveData = NonNullMutableLiveData<List<Article>>()


    override fun getTopHeaders() {
        compositeDisposable += newsRepository.getTopHeadlines()
            .subscribeBy(
                onSuccess = {
                    topHeadersLiveData.value = it
                },
                onError = {
                    Log.d("DutchNews", "WOW! thats error. check logs")
                    errorEventLiveData.value = Event(it.message ?: "Unexpected error")
                }
            )
    }
}
