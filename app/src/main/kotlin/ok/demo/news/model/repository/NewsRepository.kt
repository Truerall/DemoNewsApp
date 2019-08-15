package ok.demo.news.model.repository

import io.reactivex.Single
import ok.demo.news.model.api.Constants
import ok.demo.news.model.api.NewsApiService
import ok.demo.news.model.data_models.Article
import ok.demo.news.utils.rx.ISchedulerProvider
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsApiService: NewsApiService,
    private val schedulerProvider: ISchedulerProvider
) : INewsRepository {

    override var topHeadlinesCnt: Int = 0

    override fun getTopHeadlines(itemsCnt: Int): Single<List<Article>> {
        if (itemsCnt != 0 && itemsCnt == topHeadlinesCnt) {
            return Single.fromCallable { throw Exception("No more news :(") }
        }
        return newsApiService.getTopHeadlines(page = itemsCnt / Constants.DEFAULT_PAGE_SIZE + 1) // API gives same result for page == 0 and 1.
            .map {
                topHeadlinesCnt = it.totalResults
                it.articles
            }
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
    }
}