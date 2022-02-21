package com.nahlasamir244.newsapp.data.api

import com.nahlasamir244.newsapp.data.model.NewsWireResponse
import com.nahlasamir244.newsapp.utils.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsApiService {
    @GET("/{source}/{section}.json")
    suspend fun getNewsList(
        @Path(value = "source", encoded = true) source: String = "all",
        @Path(value = "section", encoded = true) section: String = "all",
        @Query(value = "api-key") apiKey: String = Constants.API_KEY
    ): Response<NewsWireResponse>
}