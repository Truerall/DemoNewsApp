package nl.tmg.dutchnews

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import nl.tmg.dutchnews.di.DaggerDutchNewsAppComponent
import nl.tmg.dutchnews.di.DutchNewsAppComponent
import javax.inject.Inject

class DutchNewsApp : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    private val appComponent: DutchNewsAppComponent by lazy {
        DaggerDutchNewsAppComponent
            .builder()
            .application(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingActivityInjector
    }
}