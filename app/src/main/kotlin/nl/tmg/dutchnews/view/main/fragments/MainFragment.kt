package nl.tmg.dutchnews.view.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import nl.tmg.dutchnews.R
import nl.tmg.dutchnews.model.data_models.Article
import nl.tmg.dutchnews.view.BaseVMFragment
import nl.tmg.dutchnews.view_model.BaseViewModel
import nl.tmg.dutchnews.view_model.main.MainViewModel

class MainFragment : BaseVMFragment<MainViewModel>() {

    override val modelClass: Class<out BaseViewModel>
        get() = MainViewModel::class.java

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getTopHeaders()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewModel.errorEventLiveData.observeEvent(viewLifecycleOwner, this::handleError)
        viewModel.topHeadersLiveData.observeNonNull(viewLifecycleOwner, this::displayData)
        return inflater.inflate(R.layout.frg_main, container, false)
    }

    private fun displayData(issuesList: List<Article>) {
        //adapter.setData(issuesList)
    }

    private fun handleError(errorMessage: String) {
        view?.let {
            Snackbar.make(it, errorMessage, Snackbar.LENGTH_LONG).show()
        }
    }
}