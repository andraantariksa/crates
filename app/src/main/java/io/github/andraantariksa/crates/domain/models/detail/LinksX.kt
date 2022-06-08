package io.github.andraantariksa.crates.domain.models.detail


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