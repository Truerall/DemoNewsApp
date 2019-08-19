package ok.demo.news.view.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.frg_details.*
import ok.demo.news.R
import ok.demo.news.model.data_models.Article
import ok.demo.news.utils.dbg
import ok.demo.news.view.BaseVMFragment
import ok.demo.news.view.main.MainRouter
import ok.demo.news.view.main.adapter.DetailsListAdapter
import ok.demo.news.view.main.adapter.DetailsViewModel
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

    private val adapter by lazy { DetailsListAdapter(requireContext()) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewModel.selectedArticle.observeNonNull(viewLifecycleOwner, this::displayArticleDetails)
        return inflater.inflate(R.layout.frg_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        rv_details_list.layoutManager = LinearLayoutManager(requireContext())
        rv_details_list.adapter = adapter
    }

    private fun displayArticleDetails(article: Article) {
        article.author?.let {
            (requireActivity() as AppCompatActivity).supportActionBar?.title = it
        }

        Glide.with(this)
            .load(article.urlToImage)
            .placeholder(R.drawable.ic_news_place_holder)
            .into(frg_details_iv_image)

        adapter.setData(DetailsViewModel.mapToViewModel(article, requireContext()))
    }
}