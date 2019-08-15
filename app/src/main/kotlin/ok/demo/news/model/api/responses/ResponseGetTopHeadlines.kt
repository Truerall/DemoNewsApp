package ok.demo.news.model.api.responses

import com.squareup.moshi.Json
import ok.demo.news.model.data_models.Article

data class ResponseGetTopHeadlines(
    @field:Json(name = "articles") val articles: List<Article>,
    @field:Json(name = "status") val status: String,
    @field:Json(name = "totalResults") val totalResults: Int
)