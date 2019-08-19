package ok.demo.news.view.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.frg_details.*
import ok.demo.news.R
import ok.demo.news.model.data_models.Article
import ok.demo.news.utils.dbg
import ok.demo.news.view.BaseVMFragment
import ok.demo.news.view.main.MainRouter
import ok.demo.news.view_model.BaseViewModel
import ok.demo.news.view_model.main.MainViewModel


class DetailsFragment : BaseVMFragment<MainViewModel, MainRouter>() {

    override val activityScope: ViewModelScope
        get() = ViewModelScope.ACTIVITY

    override val modelClass: Class<out BaseViewModel>
        get() = MainViewModel::class.java

    companion object {
        fun newInstance() = DetailsFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dbg("Details Frg created")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewModel.selectedArticle.observeNonNull(viewLifecycleOwner, this::displayArticleDetails)
        return inflater.inflate(R.layout.frg_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
    }

    private fun displayArticleDetails(article: Article) {
        test_description.text = article.description
        test_data.text = article.content
        test_data.text = getString(R.string.dm_frg_main_item_article_description_extra_long)
        dbg("DisplayTriggered")
    }


}