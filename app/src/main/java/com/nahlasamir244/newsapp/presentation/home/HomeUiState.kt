package com.nahlasamir244.newsapp.presentation.home

import com.nahlasamir244.newsapp.data.model.News

data class HomeUiState(
    val loading:Boolean,
    val newsList : List<News>? =null,
    val errorMessage:String?=null
)