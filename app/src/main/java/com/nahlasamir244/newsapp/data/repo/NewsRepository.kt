package com.nahlasamir244.newsapp.data.repo

import com.nahlasamir244.newsapp.data.model.NewsWireResponse
import retrofit2.Response

interface NewsRepository {
    suspend fun getNewsList(): Response<NewsWireResponse>
}