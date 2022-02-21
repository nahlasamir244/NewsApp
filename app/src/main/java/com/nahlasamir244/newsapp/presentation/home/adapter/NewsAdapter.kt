package com.nahlasamir244.newsapp.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nahlasamir244.newsapp.data.model.News
import com.nahlasamir244.newsapp.databinding.ItemNewsBinding

class NewsAdapter(
    private val newsAdapterHandler: NewsAdapterHandler
) : ListAdapter<News, NewsAdapter.NewsViewHolder>(NEWS_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val itemNewsBinding = ItemNewsBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return NewsViewHolder(itemNewsBinding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class NewsViewHolder(private val itemNewsBinding: ItemNewsBinding) :
        RecyclerView.ViewHolder(itemNewsBinding.root) {
        init {
            itemNewsBinding.apply {
                root.setOnClickListener {
                    val currentPosition = layoutPosition
                    if (currentPosition != RecyclerView.NO_POSITION) {
                        newsAdapterHandler.onNewsItemClicked(getItem(currentPosition))
                    }
                }
            }
        }

        fun bind(news: News) {
            itemNewsBinding.apply {
                textViewNewsTitle.text = news.title
            }
        }
    }

    companion object {
        private val NEWS_COMPARATOR = object : DiffUtil.ItemCallback<News>() {
            //assuming slugName is unique property
            override fun areItemsTheSame(oldItem: News, newItem: News): Boolean =
                oldItem.slugName == newItem.slugName

            override fun areContentsTheSame(oldItem: News, newItem: News): Boolean =
                oldItem == newItem

        }
    }

}