package io.github.andraantariksa.cratesio.data.network

import io.github.andraantariksa.cratesio.data.network.model.CrateSummary.CrateSummary
import io.github.andraantariksa.cratesio.data.network.model.CratesDetail.CratesDetail
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface CratesioAPIService {
    @GET("summary")
    suspend fun getSummary(): CrateSummary

    @GET("value/crates/{cratesId}")
    suspend fun getCratesDetail(@Path("cratesId") cratesId : String): CratesDetail

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