package nl.tmg.dutchnews.di.ui.main

import dagger.Module
import dagger.android.ContributesAndroidInjector
import nl.tmg.dutchnews.di.scopes.FragmentScope
import nl.tmg.dutchnews.view.main.fragments.MainFragment

@Module
abstract class MainActivityFragmentBuilder {

    @FragmentScope
    @ContributesAndroidInjector(modules = [])
    abstract fun bindTransactionsListFragment(): MainFragment

}