package io.github.andraantariksa.crates.feature_crates.data.source.remote.model.detail


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AuditAction(
    @Json(name = "action")
    val action: String,
    @Json(name = "time")
    val time: String,
    @Json(name = "user")
    val user: User
)