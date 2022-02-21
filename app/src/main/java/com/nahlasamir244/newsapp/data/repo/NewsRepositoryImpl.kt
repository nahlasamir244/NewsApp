package com.nahlasamir244.newsapp.data.repo

import com.nahlasamir244.newsapp.data.datasource.remote.NewsRemoteDataSource
import com.nahlasamir244.newsapp.data.model.NewsWireResponse
import retrofit2.Response
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsRemoteDataSource: NewsRemoteDataSource
) : NewsRepository {
    override suspend fun getNewsList(): Response<NewsWireResponse> =
        newsRemoteDataSource.getNewsList()

}