package io.github.andraantariksa.crates.domain.models.detail


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Crate(
    @Json(name = "badges")
    val badges: List<Any>,
    @Json(name = "categories")
    val categories: List<Any>,
    @Json(name = "created_at")
    val createdAt: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "documentation")
    val documentation: Any,
    @Json(name = "downloads")
    val downloads: Int,
    @Json(name = "exact_match")
    val exactMatch: Boolean,
    @Json(name = "homepage")
    val homepage: Any,
    @Json(name = "id")
    val id: String,
    @Json(name = "keywords")
    val keywords: List<Any>,
    @Json(name = "links")
    val links: Links,
    @Json(name = "max_stable_version")
    val maxStableVersion: String,
    @Json(name = "max_version")
    val maxVersion: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "newest_version")
    val newestVersion: String,
    @Json(name = "recent_downloads")
    val recentDownloads: Int,
    @Json(name = "repository")
    val repository: Any,
    @Json(name = "updated_at")
    val updatedAt: String,
    @Json(name = "versions")
    val versions: List<Int>
)