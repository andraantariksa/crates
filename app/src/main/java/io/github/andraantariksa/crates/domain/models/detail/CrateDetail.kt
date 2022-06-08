package io.github.andraantariksa.crates.domain.models.detail


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CrateDetail(
    @Json(name = "categories")
    val categories: List<Any>,
    @Json(name = "crate")
    val crate: Crate,
    @Json(name = "keywords")
    val keywords: List<Any>,
    @Json(name = "versions")
    val versions: List<Version>
)