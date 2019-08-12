package nl.tmg.dutchnews.view.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import nl.tmg.dutchnews.R
import nl.tmg.dutchnews.view.main.fragments.MainFragment

class MainActivity : AppCompatActivity() {

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