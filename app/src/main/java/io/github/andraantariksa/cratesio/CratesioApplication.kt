package io.github.andraantariksa.cratesio

import android.app.Application
import io.github.andraantariksa.cratesio.data.network.ConnectivityInterceptor
import io.github.andraantariksa.cratesio.data.network.ConnectivityInterceptorImpl
import io.github.andraantariksa.cratesio.data.network.CratesioAPIService
import io.github.andraantariksa.cratesio.data.network.datasource.CrateSummaryDatasource
import io.github.andraantariksa.cratesio.data.network.datasource.CrateSummaryDatasourceImpl
import io.github.andraantariksa.cratesio.data.repository.CrateSummaryRepository
import io.github.andraantariksa.cratesio.data.repository.CrateSummaryRepositoryImpl
import io.github.andraantariksa.cratesio.ui.SummaryViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class CratesioApplication : Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@CratesioApplication))

        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton { CratesioAPIService(instance()) }
        bind<CrateSummaryDatasource>() with singleton { CrateSummaryDatasourceImpl(instance()) }
        bind<CrateSummaryRepository>() with singleton { CrateSummaryRepositoryImpl(instance()) }
        bind() from provider {
            SummaryViewModelFactory(
                instance()
            )
        }
    }
}