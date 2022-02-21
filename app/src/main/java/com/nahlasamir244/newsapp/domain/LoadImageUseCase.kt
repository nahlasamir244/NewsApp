package com.nahlasamir244.newsapp.domain

import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.nahlasamir244.newsapp.application.NewsApp

typealias LoadImage = LoadImageUseCase

class LoadImageUseCase {
    operator fun invoke(imageView: ImageView, url: String, placeholderResourceId: Int) =
        Glide.with(imageView).load(url)
            .placeholder(
                ContextCompat.getDrawable(
                    NewsApp.getAppContext(),
                    placeholderResourceId
                )
            ).into(imageView)
}