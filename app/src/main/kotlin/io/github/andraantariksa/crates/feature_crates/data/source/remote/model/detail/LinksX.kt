package io.github.andraantariksa.crates.feature_crates.data.source.remote.model.detail


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LinksX(
    @Json(name = "authors")
    val authors: String,
    @Json(name = "dependencies")
    val dependencies: String,
    @Json(name = "version_downloads")
    val versionDownloads: String
)