package ok.demo.news.view.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.frg_main.*
import ok.demo.news.R
import ok.demo.news.model.data_models.Article
import ok.demo.news.view.BaseVMFragment
import ok.demo.news.view.main.MainListAdapter
import ok.demo.news.view.main.adapter.PaginationScrollListener
import ok.demo.news.view_model.BaseViewModel
import ok.demo.news.view_model.main.MainViewModel

class MainFragment : BaseVMFragment<MainViewModel>() {

    private val adapter by lazy { MainListAdapter(requireContext()) }
    private lateinit var paginationScrollListener: PaginationScrollListener

    override val modelClass: Class<out BaseViewModel>
        get() = MainViewModel::class.java

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            viewModel.getTopHeaders(adapter.itemCount)
            adapter.onItemClick = {
                view?.let {
                    Snackbar.make(it, "Not implemented. Give me +1 day please.", Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewModel.errorEventLiveData.observeEvent(viewLifecycleOwner, this::handleError)
        viewModel.topHeadersLiveData.observeNonNull(viewLifecycleOwner, this::displayData)
        return inflater.inflate(R.layout.frg_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(requireContext())
        rv_main_list.layoutManager = layoutManager
        rv_main_list.adapter = adapter
        paginationScrollListener = PaginationScrollListener(layoutManager) {
            viewModel.getTopHeaders(adapter.itemCount)
        }
        rv_main_list.addOnScrollListener(paginationScrollListener)
    }

    private fun displayData(issuesList: List<Article>) {
        adapter.setData(issuesList)
        paginationScrollListener.isLoading = false
    }

    private fun handleError(errorMessage: String) {
        view?.let {
            Snackbar.make(it, errorMessage, Snackbar.LENGTH_LONG).show()
            paginationScrollListener.isLoading = false
        }
    }
}