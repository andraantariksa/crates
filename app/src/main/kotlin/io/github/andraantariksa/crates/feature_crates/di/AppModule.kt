package io.github.andraantariksa.crates.feature_crates.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.github.andraantariksa.crates.feature_crates.data.repository.CratesIoRepositoryImpl
import io.github.andraantariksa.crates.feature_crates.data.source.local.CratesIoDataSourceLocal
import io.github.andraantariksa.crates.feature_crates.data.source.local.CratesIoDataSourceLocalImpl
import io.github.andraantariksa.crates.feature_crates.data.source.local.database.CratesDatabase
import io.github.andraantariksa.crates.feature_crates.data.source.remote.CratesIoDataSourceRemote
import io.github.andraantariksa.crates.feature_crates.data.source.remote.CratesIoDataSourceRemoteImpl
import io.github.andraantariksa.crates.feature_crates.data.source.remote.service.ConnectivityInterceptor
import io.github.andraantariksa.crates.feature_crates.data.source.remote.service.CratesIoAPIService
import io.github.andraantariksa.crates.feature_crates.domain.repository.CratesIoRepository
import okhttp3.JavaNetCookieJar
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.net.CookieManager
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideCratesioAPIService(@ApplicationContext context: Context): CratesIoAPIService {
        val okHttpClient = OkHttpClient
            .Builder()
            .addInterceptor(HttpLoggingInterceptor())
            .addInterceptor(ConnectivityInterceptor(context))
            .cookieJar(JavaNetCookieJar(CookieManager()))
            .build()

        return Retrofit
            .Builder()
            .client(okHttpClient)
            .baseUrl("https://crates.io/api/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(CratesIoAPIService::class.java)
    }

    @Singleton
    @Provides
    fun provideCratesIoDataSourceRemote(cratesioAPIService: CratesIoAPIService): CratesIoDataSourceRemote =
        CratesIoDataSourceRemoteImpl(cratesioAPIService)

    @Singleton
    @Provides
    fun provideCratesDatabase(@ApplicationContext context: Context): CratesDatabase =
        Room
            .databaseBuilder(context, CratesDatabase::class.java, CratesDatabase.NAME)
            .build()

    @Singleton
    @Provides
    fun provideCratesIoDataSourceLocal(): CratesIoDataSourceLocal =
        CratesIoDataSourceLocalImpl()

    @Singleton
    @Provides
    fun provideCratesIoRepository(
        cratesIoDatasourceRemote: CratesIoDataSourceRemote,
        cratesIoDatasourceLocal: CratesIoDataSourceLocal
    ): CratesIoRepository =
        CratesIoRepositoryImpl(
            cratesIoDatasourceLocal = cratesIoDatasourceLocal,
            cratesIoDatasourceRemote = cratesIoDatasourceRemote
        )
}