package nl.tmg.dutchnews.utils.architecture

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

/**
 * Small utility class that can be used when you want to use MutableLiveData for values that can
 * never be null.
 */
open class NonNullMutableLiveData<T : Any> : MutableLiveData<T>() {

    override fun getValue(): T {
        return super.getValue()!!
    }

    fun observeNonNull(owner: LifecycleOwner, body: (T) -> Unit) {
        super.observe(owner, Observer<T> { t -> body(t!!) })
    }
}
