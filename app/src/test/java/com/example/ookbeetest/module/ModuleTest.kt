package com.example.ookbeetest.module

import android.app.Application
import android.content.Context
import com.example.ookbeetest.presentation.di.appMoule
import org.junit.Test
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.check.checkModules
import org.mockito.Mockito

class ModuleTest : KoinTest {

    private val context: Context = Mockito.mock(Application::class.java)


    @Test
    fun `Test Koin Modules`() {
        startKoin {
            androidContext(context)
            modules(listOf(appMoule))
        }.checkModules()

        stopKoin()
    }
}