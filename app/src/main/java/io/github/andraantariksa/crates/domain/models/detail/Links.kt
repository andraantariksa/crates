package io.github.andraantariksa.crates.domain.models.detail


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Links(
    @Json(name = "owner_team")
    val ownerTeam: String,
    @Json(name = "owner_user")
    val ownerUser: String,
    @Json(name = "owners")
    val owners: String,
    @Json(name = "reverse_dependencies")
    val reverseDependencies: String,
    @Json(name = "version_downloads")
    val versionDownloads: String,
    @Json(name = "versions")
    val versions: Any
)