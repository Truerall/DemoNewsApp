package ok.demo.news.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import ok.demo.news.DemoNewsApp
import ok.demo.news.di.viewmodel.ViewModelModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuilder::class,
        NewsAppProviderModule::class,
        NewsAppBindingModule::class,
        ViewModelModule::class]
)
interface NewsAppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): NewsAppComponent
    }

    fun inject(instance: DemoNewsApp)
}