package io.github.andraantariksa.crates.domain.models.detail


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PublishedBy(
    @Json(name = "avatar")
    val avatar: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "login")
    val login: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "url")
    val url: String
)