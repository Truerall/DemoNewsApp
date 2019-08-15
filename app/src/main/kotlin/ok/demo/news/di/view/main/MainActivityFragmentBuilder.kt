package ok.demo.news.di.view.main

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ok.demo.news.di.scopes.FragmentScope
import ok.demo.news.view.main.fragments.MainFragment

@Module
abstract class MainActivityFragmentBuilder {

    @FragmentScope
    @ContributesAndroidInjector(modules = [])
    abstract fun bindMainFragment(): MainFragment

}