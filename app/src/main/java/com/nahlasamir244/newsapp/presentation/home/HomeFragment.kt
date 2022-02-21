package com.nahlasamir244.newsapp.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.nahlasamir244.newsapp.R
import com.nahlasamir244.newsapp.data.model.News
import com.nahlasamir244.newsapp.databinding.HomeFragmentBinding
import com.nahlasamir244.newsapp.presentation.home.adapter.NewsAdapter
import com.nahlasamir244.newsapp.presentation.home.adapter.NewsAdapterHandler
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(), NewsAdapterHandler {

    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var binding: HomeFragmentBinding
    private lateinit var newsAdapter: NewsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val decoration = DividerItemDecoration(
            requireContext(), DividerItemDecoration.VERTICAL
        )
        newsAdapter = NewsAdapter(this)
        binding = HomeFragmentBinding.bind(view)
        binding.apply {
            viewModel = homeViewModel
            recyclerViewNews.apply {
                adapter = newsAdapter
                layoutManager = LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.VERTICAL,
                    false
                )
                addItemDecoration(decoration)
            }
            lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel!!.homeUiState.collectLatest {
                        newsAdapter.submitList(it.newsList)
                        progressBar.isVisible = it.loading
                        recyclerViewNews.isVisible = it.errorMessage.isNullOrEmpty() && !it.loading
                        textViewErrorMessage.text = it.errorMessage
                        textViewErrorMessage.isVisible = !it.errorMessage.isNullOrEmpty()

                    }
                }
            }
        }
    }

    override fun onNewsItemClicked(news: News) {
        navigateToNewsPreview(news)
    }

    private fun navigateToNewsPreview(news: News) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToNewsPreviewFragment(
                news
            )
        )
    }

}