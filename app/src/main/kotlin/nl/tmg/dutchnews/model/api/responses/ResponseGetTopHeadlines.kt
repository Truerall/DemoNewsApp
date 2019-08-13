package nl.tmg.dutchnews.model.api.responses

import com.squareup.moshi.Json
import nl.tmg.dutchnews.model.data_models.Article

data class ResponseGetTopHeadlines(
    @field:Json(name = "articles") val articles: List<Article>,
    @field:Json(name = "status") val status: String,
    @field:Json(name = "totalResults") val totalResults: Int
)