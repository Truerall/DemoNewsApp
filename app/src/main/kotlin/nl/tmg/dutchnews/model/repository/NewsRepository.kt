package nl.tmg.dutchnews.model.repository

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import nl.tmg.dutchnews.model.api.NewsApiService
import nl.tmg.dutchnews.model.data_models.Article
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsApiService: NewsApiService
) : INewsRepository {

    override var topHeadlinesCnt: Int = 0

    override fun getTopHeadlines(): Single<List<Article>> {
        return newsApiService.getTopHeadlines()
            .map {
                topHeadlinesCnt = it.totalResults
                it.articles
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}