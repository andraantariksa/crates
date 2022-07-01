package io.github.andraantariksa.crates.feature_crates.data.source.remote.model.sign_in

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AuthBegin(
    @Json(name = "state")
    val state: String,
    @Json(name = "url")
    val url: String,
)