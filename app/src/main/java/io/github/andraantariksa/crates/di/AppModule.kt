package io.github.andraantariksa.crates.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.github.andraantariksa.crates.data.repository.CratesIoRepositoryImpl
import io.github.andraantariksa.crates.data.source.remote.internet.ConnectivityInterceptor
import io.github.andraantariksa.crates.data.source.remote.internet.CratesIoAPIService
import io.github.andraantariksa.crates.data.source.remote.internet.CratesIoDataSourceInternet
import io.github.andraantariksa.crates.domain.repository.CratesIoRepository
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
    fun provideCratesIoDataSourceInternet(cratesioAPIService: CratesIoAPIService): CratesIoDataSourceInternet =
        CratesIoDataSourceInternet(cratesioAPIService)

    @Singleton
    @Provides
    fun provideCratesIoRepository(cratesIoDatasourceInternet: CratesIoDataSourceInternet): CratesIoRepository =
        CratesIoRepositoryImpl(cratesIoDatasourceInternet = cratesIoDatasourceInternet)
}