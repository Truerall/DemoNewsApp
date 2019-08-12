package nl.tmg.dutchnews.view.main.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import nl.tmg.dutchnews.R
import nl.tmg.dutchnews.view.BaseVMFragment
import nl.tmg.dutchnews.view_model.BaseViewModel
import nl.tmg.dutchnews.view_model.main.MainViewModel

class MainFragment : BaseVMFragment<MainViewModel>() {

    override val modelClass: Class<out BaseViewModel>
        get() = MainViewModel::class.java

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.frg_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("DutchNews", "MainViewModel testProperty>> ${viewModel.testProperty}")
    }
}