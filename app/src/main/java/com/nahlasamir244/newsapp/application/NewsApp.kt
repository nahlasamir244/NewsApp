package com.nahlasamir244.newsapp.application

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NewsApp :Application() {

    companion object {
        private lateinit var context: Context
        fun getAppContext(): Context {
            return context
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}