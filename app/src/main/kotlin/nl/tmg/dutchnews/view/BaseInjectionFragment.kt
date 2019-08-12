package nl.tmg.dutchnews.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection

abstract class BaseInjectionFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
    }
}