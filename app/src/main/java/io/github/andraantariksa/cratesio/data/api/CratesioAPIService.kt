package io.github.andraantariksa.cratesio.data.api

import io.github.andraantariksa.cratesio.data.api.model.CrateSummary.CrateSummary
import io.github.andraantariksa.cratesio.data.api.model.CratesDetail.CratesDetail
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

const val API_BASE_URL: String = "https://crates.io/api/v1/"

interface CratesioAPIService {
    @GET("summary")
    suspend fun getSummary(): CrateSummary

    @GET("value/crates/{cratesId}")
    suspend fun getCratesDetail(@Path("cratesId") cratesId: Int): CratesDetail

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
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CratesioAPIService::class.java)
        }
    }
}