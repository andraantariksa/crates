package io.github.andraantariksa.cratesio.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.github.andraantariksa.cratesio.R
import io.github.andraantariksa.cratesio.data.source.internet.ConnectivityInterceptor
import io.github.andraantariksa.cratesio.data.source.internet.CratesioAPIService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ActivityModule {

    @Singleton
    @Provides
    fun provideRetrofitInstance(@ApplicationContext context: Context): Retrofit {
        val okHttpClient = OkHttpClient
            .Builder()
            .addInterceptor(ConnectivityInterceptor(context))
            .build()

        return Retrofit
            .Builder()
            .client(okHttpClient)
            .baseUrl(context.getString(R.string.cratesio_api_base_url))
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideCratesioAPIService(retrofit: Retrofit): CratesioAPIService =
        retrofit.create(CratesioAPIService::class.java)

}