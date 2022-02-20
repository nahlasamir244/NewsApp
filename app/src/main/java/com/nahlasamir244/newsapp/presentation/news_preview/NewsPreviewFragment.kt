package com.nahlasamir244.newsapp.presentation.news_preview

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nahlasamir244.newsapp.R

class NewsPreviewFragment : Fragment() {

    companion object {
        fun newInstance() = NewsPreviewFragment()
    }

    private lateinit var viewModel: NewsPreviewViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.news_preview_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NewsPreviewViewModel::class.java)
        // TODO: Use the ViewModel
    }

}