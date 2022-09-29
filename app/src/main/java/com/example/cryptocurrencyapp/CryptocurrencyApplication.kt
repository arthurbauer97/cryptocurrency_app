package com.example.cryptocurrencyapp

import android.app.Application
import com.example.cryptocurrencyapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class CryptocurrencyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidLogger(Level.NONE)
            androidContext(this@CryptocurrencyApplication)
            modules(appModule)
        }

    }

}