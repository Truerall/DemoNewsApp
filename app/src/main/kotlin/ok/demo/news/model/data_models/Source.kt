package ok.demo.news.model.data_models

import com.squareup.moshi.Json

data class Source(
    @field:Json(name = "id") val id: String?, //not actually a unique id, but just id of source w/o warranty of uniqueness in api.
    @field:Json(name = "name") val name: String
)