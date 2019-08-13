package nl.tmg.dutchnews.di

import android.app.Application
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import nl.tmg.dutchnews.BuildConfig
import nl.tmg.dutchnews.R
import nl.tmg.dutchnews.model.api.Constants
import nl.tmg.dutchnews.model.api.NewsApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class DutchNewsAppProviderModule {

    @Provides
    @Singleton
    internal fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(client)
            .baseUrl(BuildConfig.API_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    internal fun provideUsersApiService(apiClient: Retrofit): NewsApiService {
        return apiClient.create(NewsApiService::class.java)
    }

    @Provides
    @Singleton
    internal fun provideClient(application: Application): OkHttpClient {
        val builder = OkHttpClient.Builder()
        val logInterceptor = HttpLoggingInterceptor()
        logInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val headerInterceptor = Interceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader(Constants.HEADER_AUTH, application.getString(R.string.app_api_key))
                .build()
            chain.proceed(request)
        }

        builder.addInterceptor(logInterceptor)
        builder.addInterceptor(headerInterceptor)

        return builder.build()
    }

}