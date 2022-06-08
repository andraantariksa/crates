package io.github.andraantariksa.crates.domain.models.summary


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PopularCategory(
    @Json(name = "category")
    val category: String,
    @Json(name = "crates_cnt")
    val cratesCnt: Int,
    @Json(name = "created_at")
    val createdAt: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "id")
    val id: String,
    @Json(name = "slug")
    val slug: String
)