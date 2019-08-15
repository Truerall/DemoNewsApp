package ok.demo.news.view_model.main

import android.util.Log
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import ok.demo.news.model.data_models.Article
import ok.demo.news.model.repository.INewsRepository
import ok.demo.news.utils.architecture.Event
import ok.demo.news.utils.architecture.EventLiveData
import ok.demo.news.utils.architecture.NonNullMutableLiveData
import ok.demo.news.view_model.BaseViewModel
import ok.demo.news.view_model.IBaseViewModel
import javax.inject.Inject

interface IMainViewModelContract : IBaseViewModel {
    val errorEventLiveData: EventLiveData<String>
    val topHeadersLiveData: NonNullMutableLiveData<List<Article>>
    fun getTopHeaders(itemsCnt : Int)
}

class MainViewModel @Inject constructor(private val newsRepository: INewsRepository) : BaseViewModel(),
    IMainViewModelContract {

    override val errorEventLiveData = EventLiveData<String>()
    override val topHeadersLiveData = NonNullMutableLiveData<List<Article>>()


    override fun getTopHeaders(itemsCnt : Int) {
        compositeDisposable += newsRepository.getTopHeadlines(itemsCnt)
            .subscribeBy(
                onSuccess = {
                    topHeadersLiveData.value = it
                },
                onError = {
                    Log.d("NewsApp", "WOW! thats error. check logs")
                    errorEventLiveData.value = Event(it.message ?: "Unexpected error")
                }
            )
    }
}
