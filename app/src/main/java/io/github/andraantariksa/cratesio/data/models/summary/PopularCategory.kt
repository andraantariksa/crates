package io.github.andraantariksa.cratesio.data.models.summary

data class PopularCategory(
    val category: String,
    val crates_cnt: Int,
    val created_at: String,
    val description: String,
    val id: String,
    val slug: String
)