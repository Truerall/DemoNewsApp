package nl.tmg.dutchnews.model.api

import io.reactivex.Completable
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("top-headlines")
    fun getTopHeadlines(
        @Query(Constants.PAGE_SIZE) pageSize: Int = 20,
        @Query(Constants.COUNTRY) country: String = "nl"
    ): Completable// no return value for test purposes. We will parse the response later
}
