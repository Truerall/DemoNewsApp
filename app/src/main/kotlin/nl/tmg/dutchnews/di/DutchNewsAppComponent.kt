package nl.tmg.dutchnews.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import nl.tmg.dutchnews.DutchNewsApp
import nl.tmg.dutchnews.di.viewmodel.ViewModelModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuilder::class,
        DutchNewsAppProviderModule::class,
        DutchNewsAppBindingModule::class,
        ViewModelModule::class]
)
interface DutchNewsAppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): DutchNewsAppComponent
    }

    fun inject(instance: DutchNewsApp)
}