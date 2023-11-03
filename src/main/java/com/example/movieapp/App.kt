package com.example.movieapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class App:Application() {
    override fun onCreate() {
        super.onCreate()
        //Log라이브러리
        Timber.plant(Timber.DebugTree())
    }
}