package ok.demo.news.model.repository

import io.reactivex.Single
import ok.demo.news.model.data_models.Article

interface INewsRepository {
    val topHeadlinesCnt: Int
    fun getTopHeadlines(itemsCnt: Int): Single<List<Article>>
}