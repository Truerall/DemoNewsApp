package nl.tmg.dutchnews.model.repository

import io.reactivex.Single
import nl.tmg.dutchnews.model.data_models.Article

interface INewsRepository {
    val topHeadlinesCnt: Int
    fun getTopHeadlines(): Single<List<Article>>
}