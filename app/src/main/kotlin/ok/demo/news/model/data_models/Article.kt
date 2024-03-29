package ok.demo.news.model.data_models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
data class Article(
    @field:Json(name = "author")  val author: String? = "Unknown author",
    @field:Json(name = "content") val content: String,
    @field:Json(name = "description") val description: String? = "",
    @field:Json(name = "publishedAt") val publishedAt: Date,
    @field:Json(name = "source") val source: Source,
    @field:Json(name = "title") val title: String,
    @field:Json(name = "url") val url: String,
    @field:Json(name = "urlToImage") val urlToImage: String?
)