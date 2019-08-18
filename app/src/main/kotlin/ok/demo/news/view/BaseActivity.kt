package ok.demo.news.view

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ok.demo.news.R

abstract class BaseActivity : AppCompatActivity() {

    protected fun addFragment(fragment: Fragment, addToBackStack: Boolean) {
        addFragment(fragment, fragment::class.java.simpleName, addToBackStack)
    }

    protected fun addFragment(fragment: Fragment, tag: String, addToBackStack: Boolean) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.container, fragment, tag)
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(tag)
        }
        fragmentTransaction.commit()
    }

}