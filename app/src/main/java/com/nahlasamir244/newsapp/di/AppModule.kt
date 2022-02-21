package com.nahlasamir244.newsapp.di

import com.nahlasamir244.newsapp.data.api.NewsApiService
import com.nahlasamir244.newsapp.data.datasource.local.NewsLocalDataSource
import com.nahlasamir244.newsapp.data.datasource.local.NewsLocalDataSourceImpl
import com.nahlasamir244.newsapp.data.datasource.remote.NewsRemoteDataSource
import com.nahlasamir244.newsapp.data.datasource.remote.NewsRemoteDataSourceImpl
import com.nahlasamir244.newsapp.data.repo.NewsRepository
import com.nahlasamir244.newsapp.data.repo.NewsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// here we add dependencies that we are using inside the whole application (app scope)
@Module
@InstallIn(ApplicationComponent::class)
object AppModule {
    @ApplicationScope
    @Provides
    @Singleton
    fun provideApplicationScope() = CoroutineScope(SupervisorJob())

    @Provides
    @BaseUrl
    @Singleton
    fun provideBaseUrl() = "https://api.nytimes.com/svc/news/v3/content"

    @Provides
    @Singleton
    fun provideOkHttpClient() = run {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }


    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient, @BaseUrl baseUrl: String,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(gsonConverterFactory)
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideNewsApiService(retrofit: Retrofit): NewsApiService =
        retrofit.create(NewsApiService::class.java)

    @Provides
    @Singleton
    fun provideNewsRemoteDataSource(newsRemoteDataSourceImpl: NewsRemoteDataSourceImpl)
            : NewsRemoteDataSource = newsRemoteDataSourceImpl

    @Provides
    @Singleton
    fun provideNewsLocalDataSource(newsLocalDataSourceImpl: NewsLocalDataSourceImpl)
            : NewsLocalDataSource = newsLocalDataSourceImpl


    @Provides
    @Singleton
    fun provideNewsRepository(newsRepositoryImpl: NewsRepositoryImpl)
            : NewsRepository = newsRepositoryImpl

}