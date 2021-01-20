package io.github.andraantariksa.cratesio.data.source.internet

import io.github.andraantariksa.cratesio.data.models.detail.CratesDetail
import io.github.andraantariksa.cratesio.data.models.search.CratesSearch
import io.github.andraantariksa.cratesio.data.models.summary.CratesSummary
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

const val API_BASE_URL: String = "https://crates.io/api/v1/"

interface CratesioAPIService {
    @GET("summary")
    suspend fun getSummary(): CratesSummary

    @GET("value/crates/{cratesId}")
    suspend fun getCratesDetail(@Path("cratesId") cratesId: Int): CratesDetail

    @GET("crates?page={page}&per_page={perPage}&q={query}")
    suspend fun searchCrate(
        @Path("page") page: Int,
        @Path("perPage") perPage: Int,
        @Path("query") query: String
    ): CratesSearch

    companion object {
        operator fun invoke(connectivityInterceptor: ConnectivityInterceptor): CratesioAPIService {
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

