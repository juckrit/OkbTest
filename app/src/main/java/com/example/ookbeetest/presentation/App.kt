package com.example.ookbeetest.presentation

import android.app.Application
import com.example.ookbeetest.presentation.di.appMoule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initializeKoin()

    }

    private fun initializeKoin() {
        startKoin {
            // use AndroidLogger as Koin Logger - default Level.INFO
            androidLogger()
            // use the Android context given there
            androidContext(this@App)
            // load properties from assets/koin.properties file
            androidFileProperties()
            // module list
            modules(appMoule)
        }
    }
}