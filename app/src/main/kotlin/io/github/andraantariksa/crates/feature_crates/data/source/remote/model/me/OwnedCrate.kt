package io.github.andraantariksa.crates.feature_crates.data.source.remote.model.me


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OwnedCrate(
    @Json(name = "email_notifications")
    val emailNotifications: Boolean,
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String
)