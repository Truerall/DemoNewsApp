package nl.tmg.dutchnews.model.repository

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import nl.tmg.dutchnews.model.api.Constants
import nl.tmg.dutchnews.model.api.NewsApiService
import nl.tmg.dutchnews.model.data_models.Article
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsApiService: NewsApiService
) : INewsRepository {

    override var topHeadlinesCnt: Int = 0

    override fun getTopHeadlines(itemsCnt: Int): Single<List<Article>> {
        if (itemsCnt != 0 && itemsCnt == topHeadlinesCnt){
            return Single.fromCallable { throw Exception("No more news :(") }
        }
        return newsApiService.getTopHeadlines(page = itemsCnt / Constants.DEFAULT_PAGE_SIZE + 1) // API gives same result for page == 0 and 1.
            .map {
                topHeadlinesCnt = it.totalResults
                it.articles
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}