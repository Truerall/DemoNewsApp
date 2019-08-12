package nl.tmg.dutchnews.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import nl.tmg.dutchnews.di.scopes.ActivityScope
import nl.tmg.dutchnews.di.ui.main.MainActivityFragmentBuilder
import nl.tmg.dutchnews.view.main.MainActivity

@Module
abstract class ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityFragmentBuilder::class])
    internal abstract fun bindMainActivity(): MainActivity
}