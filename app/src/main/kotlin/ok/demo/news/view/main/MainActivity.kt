package ok.demo.news.view.main

import android.os.Bundle
import ok.demo.news.R
import ok.demo.news.view.BaseInjectionActivity
import ok.demo.news.view.main.fragments.DetailsFragment
import ok.demo.news.view.main.fragments.MainFragment

class MainActivity : BaseInjectionActivity(), MainRouter {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_main)

        if (savedInstanceState == null) {
            openMainFragment()
        }
    }

    override fun openMainFragment() {
        addFragment(MainFragment.newInstance(), false)
    }

    override fun openDetailsFragment() {
        addFragment(DetailsFragment.newInstance(), true)
    }
}