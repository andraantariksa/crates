package io.github.andraantariksa.crates.feature_crates.data.source.remote.model.me


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Me(
    @Json(name = "owned_crates")
    val ownedCrates: List<OwnedCrate>,
    @Json(name = "user")
    val user: User
)