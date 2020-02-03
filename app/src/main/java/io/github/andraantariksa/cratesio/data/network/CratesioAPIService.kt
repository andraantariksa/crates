package io.github.andraantariksa.cratesio.data.network

import io.github.andraantariksa.cratesio.data.network.model.CrateSummary
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CratesioAPIService {
    @GET("summary")
    suspend fun getSummary(): CrateSummary

    companion object {
        operator fun invoke(
            connectivityInterceptor: ConnectivityInterceptor
        ): CratesioAPIService {
            val okHttpClient = OkHttpClient
                .Builder()
                .addInterceptor(connectivityInterceptor)
                .build()

            return Retrofit
                .Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CratesioAPIService::class.java)
        }
    }
}