package ok.demo.news.view.main.adapter

import android.content.Context
import android.text.format.DateFormat
import ok.demo.news.R
import ok.demo.news.model.data_models.Article

data class DetailsViewModel(val header: String, val content: String) {
    companion object {
        public fun mapToViewModel(article: Article, context: Context): List<DetailsViewModel> {
            val viewModelList = mutableListOf<DetailsViewModel>()

            viewModelList.add(DetailsViewModel(context.getString(R.string.dvm_header_description), article.description ?: ""))
            viewModelList.add(
                DetailsViewModel(
                    context.getString(R.string.dvm_header_date),
                    DateFormat.getDateFormat(context).format(article.publishedAt)
                )
            )
            viewModelList.add(DetailsViewModel(context.getString(R.string.dvm_header_source), article.source.name))
            viewModelList.add(DetailsViewModel(context.getString(R.string.dvm_header_url), article.url))
            viewModelList.add(DetailsViewModel(context.getString(R.string.dvm_header_content), article.content))
//            test purposes - to make enough content for demo of collapsing
            viewModelList.add(DetailsViewModel(context.getString(R.string.dvm_header_content), article.content))
            viewModelList.add(DetailsViewModel(context.getString(R.string.dvm_header_content), article.content))
            viewModelList.add(DetailsViewModel(context.getString(R.string.dvm_header_content), article.content))
            viewModelList.add(DetailsViewModel(context.getString(R.string.dvm_header_content), article.content))

            return viewModelList
        }
    }
}

