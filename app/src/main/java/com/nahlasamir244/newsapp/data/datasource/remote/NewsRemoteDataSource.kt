package com.nahlasamir244.newsapp.data.datasource.remote

import com.nahlasamir244.newsapp.data.model.NewsWireResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getNewsList(): Response<NewsWireResponse>
}