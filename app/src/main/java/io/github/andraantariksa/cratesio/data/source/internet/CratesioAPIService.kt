package io.github.andraantariksa.cratesio.data.source.internet

import io.github.andraantariksa.cratesio.data.models.detail.CratesDetail
import io.github.andraantariksa.cratesio.data.models.search.CratesSearch
import io.github.andraantariksa.cratesio.data.models.summary.CratesSummary
import retrofit2.http.GET
import retrofit2.http.Path

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
}

