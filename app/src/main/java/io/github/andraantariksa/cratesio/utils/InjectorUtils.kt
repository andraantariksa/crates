package io.github.andraantariksa.cratesio.utils

import android.content.Context
import io.github.andraantariksa.cratesio.data.api.ConnectivityInterceptorImpl
import io.github.andraantariksa.cratesio.data.api.CratesioAPIService
import io.github.andraantariksa.cratesio.data.api.datasource.CratesDatasourceImpl
import io.github.andraantariksa.cratesio.data.db.CratesDatabase
import io.github.andraantariksa.cratesio.data.repository.CratesRepositoryImpl
import io.github.andraantariksa.cratesio.ui.CratesViewModelFactory

object InjectorUtils {
    fun provideCratesViewModelFactory(context: Context): CratesViewModelFactory {
        val cratesioAPIService = CratesioAPIService(ConnectivityInterceptorImpl(context))
        val cratesDatabase = CratesDatabase(context)
        val cratesRepository = CratesRepositoryImpl.getInstance(
            cratesDatabase.crateSummary(),
            CratesDatasourceImpl(cratesioAPIService)
        )
        return CratesViewModelFactory(cratesRepository)
    }
}