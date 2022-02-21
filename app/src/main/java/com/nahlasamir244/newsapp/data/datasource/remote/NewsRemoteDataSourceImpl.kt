package com.nahlasamir244.newsapp.data.datasource.remote

import com.nahlasamir244.newsapp.data.api.NewsApiService
import com.nahlasamir244.newsapp.data.model.NewsWireResponse
import retrofit2.Response
import javax.inject.Inject

class NewsRemoteDataSourceImpl @Inject constructor(
    private val newsApiService: NewsApiService
) : NewsRemoteDataSource {
    override suspend fun getNewsList(): Response<NewsWireResponse> =
        newsApiService.getNewsList()
}