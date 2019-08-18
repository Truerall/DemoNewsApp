package ok.demo.news.view.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import ok.demo.news.R
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
        if (savedInstanceState == null) {

        }
        dbg("Details Frg created")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.frg_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun handleError(errorMessage: String) {
        view?.let {
            Snackbar.make(it, errorMessage, Snackbar.LENGTH_LONG).show()
        }
    }
}