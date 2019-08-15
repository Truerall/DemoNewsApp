package ok.demo.news.di

import dagger.Binds
import dagger.Module
import ok.demo.news.model.repository.INewsRepository
import ok.demo.news.model.repository.NewsRepository
import ok.demo.news.utils.rx.AppSchedulerProvider
import ok.demo.news.utils.rx.ISchedulerProvider
import javax.inject.Singleton

@Module
abstract class NewsAppBindingModule {

    @Singleton
    @Binds
    abstract fun bindIssuesRepository(transactionsRepository: NewsRepository): INewsRepository

    @Singleton
    @Binds
    abstract fun bindSchedulerProvider(appSchedulerProvider: AppSchedulerProvider): ISchedulerProvider

}