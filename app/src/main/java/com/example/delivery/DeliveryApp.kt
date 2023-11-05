package com.example.delivery

import android.app.Application
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatDelegate
import com.example.delivery.di.KoinInjector
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext

class DeliveryApp: Application() {

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        KoinInjector.koinApp.androidContext(this)
    }
}