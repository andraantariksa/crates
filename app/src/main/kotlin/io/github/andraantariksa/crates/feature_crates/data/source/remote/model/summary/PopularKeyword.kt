package io.github.andraantariksa.crates.feature_crates.data.source.remote.model.summary


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PopularKeyword(
    @Json(name = "crates_cnt")
    val cratesCnt: Int,
    @Json(name = "created_at")
    val createdAt: String,
    @Json(name = "id")
    val id: String,
    @Json(name = "keyword")
    val keyword: String
)