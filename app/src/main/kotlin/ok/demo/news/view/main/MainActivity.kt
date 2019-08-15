package ok.demo.news.view.main

import android.os.Bundle
import ok.demo.news.R
import ok.demo.news.view.BaseInjectionActivity
import ok.demo.news.view.main.fragments.MainFragment

class MainActivity : BaseInjectionActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

}