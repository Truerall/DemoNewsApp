package ok.demo.news.utils.architecture

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class EventLiveData<T : Any> : MutableLiveData<Event<T>>() {

    override fun getValue(): Event<T> {
        return super.getValue()!!
    }

    override fun observe(owner: LifecycleOwner, observer: Observer<in Event<T>>) {
        throw NotImplementedError("Please do not use observe(Observer) with EventLiveData, instead use observe(Lambda)")
    }

    override fun observeForever(observer: Observer<in Event<T>>) {
        throw NotImplementedError("Please do not use observeForever with EventLiveData, instead use observeEvent")
    }

    fun observeEvent(owner: LifecycleOwner, body: (T) -> Unit) {
        super.observe(owner, Observer<Event<T>> {
            it?.getContentIfNotHandled()?.let(body)
        })
    }
}