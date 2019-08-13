package nl.tmg.dutchnews.model.api

import io.reactivex.Completable
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("top-headlines")
    fun getTopHeadlines(
        @Query(Constants.API_KEY) authKey: String = "56752754107e4f3296007fab3c842a3f", // for test purposes. We will attach it through header later.
        @Query(Constants.PAGE_SIZE) pageSize: Int = 20,
        @Query(Constants.COUNTRY) country: String = "nl"
    ): Completable// no return value for test purposes. We will parse the response later
}
