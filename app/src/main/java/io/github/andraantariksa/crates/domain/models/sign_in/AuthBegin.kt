package io.github.andraantariksa.crates.domain.models.sign_in

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AuthBegin(
    @Json(name = "state")
    val state: String,
    @Json(name = "url")
    val url: String,
)