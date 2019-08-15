package ok.demo.news.di

import android.app.Application
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import dagger.Module
import dagger.Provides
import ok.demo.news.BuildConfig
import ok.demo.news.R
import ok.demo.news.model.api.Constants
import ok.demo.news.model.api.NewsApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*
import javax.inject.Singleton


@Module
class NewsAppProviderModule {

    @Provides
    @Singleton
    internal fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(Date::class.java, Rfc3339DateJsonAdapter().nullSafe())
            .build()
    }


    @Provides
    @Singleton
    internal fun provideRetrofit(client: OkHttpClient, moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .client(client)
            .baseUrl(BuildConfig.API_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    internal fun provideNewsApiService(apiClient: Retrofit): NewsApiService {
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