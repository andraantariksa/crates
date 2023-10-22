package io.github.andraantariksa.crates

import android.app.Application
import io.github.andraantariksa.crates.feature_crates.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CratesApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@CratesApplication)
            modules(appModule)
        }
    }
}