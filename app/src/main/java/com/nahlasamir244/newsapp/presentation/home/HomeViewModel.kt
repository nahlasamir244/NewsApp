package com.nahlasamir244.newsapp.presentation.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nahlasamir244.newsapp.data.model.News
import com.nahlasamir244.newsapp.data.repo.NewsRepository
import com.nahlasamir244.newsapp.utils.utils.helpers.NetworkStatusHelper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(
    private val newsRepository: NewsRepository,
    networkStatusHelper: NetworkStatusHelper
) : ViewModel() {
    private val _homeUiState = MutableStateFlow(HomeUiState(true))
    val homeUiState = _homeUiState.asStateFlow()

    init {
        if (networkStatusHelper.isNetworkConnected()) {
            fetchNews()
        } else {
            emitErrorState("you are offline")
        }
    }

    private fun emitErrorState(errorMessage: String) {
        _homeUiState.value = HomeUiState(
            false,
            null,
            errorMessage
        )
    }

    private fun emitSuccessState(newsList: List<News>?) {
        _homeUiState.value = HomeUiState(
            false,
            newsList
        )
    }

    private fun fetchNews() {
        viewModelScope.launch {
            val getNewsListResponse = newsRepository.getNewsList()
            if (getNewsListResponse.isSuccessful) {
                emitSuccessState(getNewsListResponse.body()?.newsList)
            } else {
                emitErrorState(getNewsListResponse.message())
            }
        }
    }
}