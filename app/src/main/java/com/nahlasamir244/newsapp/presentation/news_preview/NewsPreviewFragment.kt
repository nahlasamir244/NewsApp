package com.nahlasamir244.newsapp.presentation.news_preview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.nahlasamir244.newsapp.R
import com.nahlasamir244.newsapp.databinding.NewsPreviewFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsPreviewFragment : Fragment() {

    private val newsPreviewViewModel: NewsPreviewViewModel by viewModels()
    private lateinit var binding: NewsPreviewFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.news_preview_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = NewsPreviewFragmentBinding.bind(view)
        binding.viewModel = newsPreviewViewModel
    }

}