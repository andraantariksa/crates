package io.github.andraantariksa.cratesio.data.models.detail

data class Category(
    val category: String,
    val crates_cnt: Int,
    val created_at: String,
    val description: String,
    val id: String,
    val slug: String
)