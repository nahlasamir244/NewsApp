package com.nahlasamir244.newsapp.data.model

import com.google.gson.annotations.SerializedName


data class NewsWireResponse(

    @SerializedName("status") var status: String? = null,
    @SerializedName("copyright") var copyright: String? = null,
    @SerializedName("num_results") var total: Int? = null,
    @SerializedName("results") var newsList: ArrayList<News> = arrayListOf()

)