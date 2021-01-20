package io.github.andraantariksa.cratesio.data.models.common

data class Crate(
        val badges: List<Badge>,
        val categories: List<String>,
        val created_at: String,
        val description: String,
        val documentation: String,
        val downloads: Int,
        val exact_match: Boolean,
        val homepage: String,
        val id: String,
        val keywords: List<String>,
        val links: Links,
        val max_stable_version: String,
        val max_version: String,
        val name: String,
        val newest_version: String,
        val recent_downloads: Int,
        val repository: String,
        val updated_at: String,
        val versions: List<Int>
)