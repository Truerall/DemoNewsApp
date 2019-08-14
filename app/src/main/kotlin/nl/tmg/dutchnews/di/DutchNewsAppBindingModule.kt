package nl.tmg.dutchnews.di

import dagger.Binds
import dagger.Module
import nl.tmg.dutchnews.model.repository.INewsRepository
import nl.tmg.dutchnews.model.repository.NewsRepository
import nl.tmg.dutchnews.utils.rx.AppSchedulerProvider
import nl.tmg.dutchnews.utils.rx.ISchedulerProvider
import javax.inject.Singleton

@Module
abstract class DutchNewsAppBindingModule {

    @Singleton
    @Binds
    abstract fun bindIssuesRepository(transactionsRepository: NewsRepository): INewsRepository

    @Singleton
    @Binds
    abstract fun bindSchedulerProvider(appSchedulerProvider: AppSchedulerProvider): ISchedulerProvider

}