package com.nahlasamir244.newsapp.presentation.news_preview

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.nahlasamir244.newsapp.data.model.News

class NewsPreviewViewModel @ViewModelInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val news: News? = savedStateHandle.get<News>("news")
}