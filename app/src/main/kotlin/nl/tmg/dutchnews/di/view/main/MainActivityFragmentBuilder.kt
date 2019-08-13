package nl.tmg.dutchnews.di.view.main

import dagger.Module
import dagger.android.ContributesAndroidInjector
import nl.tmg.dutchnews.di.scopes.FragmentScope
import nl.tmg.dutchnews.view.main.fragments.MainFragment

@Module
abstract class MainActivityFragmentBuilder {

    @FragmentScope
    @ContributesAndroidInjector(modules = [])
    abstract fun bindMainFragment(): MainFragment

}