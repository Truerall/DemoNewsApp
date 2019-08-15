package ok.demo.news.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ok.demo.news.di.scopes.ActivityScope
import ok.demo.news.di.view.main.MainActivityFragmentBuilder
import ok.demo.news.view.main.MainActivity

@Module
abstract class ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityFragmentBuilder::class])
    internal abstract fun bindMainActivity(): MainActivity
}