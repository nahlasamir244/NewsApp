package com.nahlasamir244.newsapp.presentation.home.adapter

import com.nahlasamir244.newsapp.data.model.News

interface NewsAdapterHandler {
    fun onNewsItemClicked(news:News)
}