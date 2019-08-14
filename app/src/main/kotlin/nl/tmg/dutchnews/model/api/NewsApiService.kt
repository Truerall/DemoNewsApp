package nl.tmg.dutchnews.model.api

import io.reactivex.Single
import nl.tmg.dutchnews.model.api.responses.ResponseGetTopHeadlines
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("top-headlines")
    fun getTopHeadlines(
        @Query(Constants.PAGE_SIZE) pageSize: Int = Constants.DEFAULT_PAGE_SIZE,
        @Query(Constants.CURRENT_PAGE) page: Int,
        @Query(Constants.COUNTRY) country: String = "nl"
    ): Single<ResponseGetTopHeadlines>
}
