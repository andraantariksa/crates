package io.github.andraantariksa.cratesio.data.models.summary

data class PopularKeyword(
    val crates_cnt: Int,
    val created_at: String,
    val id: String,
    val keyword: String
)