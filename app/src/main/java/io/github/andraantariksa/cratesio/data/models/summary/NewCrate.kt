package io.github.andraantariksa.cratesio.data.models.summary

import io.github.andraantariksa.cratesio.data.models.common.Links

data class NewCrate(
    val badges: Any,
    val categories: Any,
    val created_at: String,
    val description: String,
    val documentation: Any,
    val downloads: Int,
    val exact_match: Boolean,
    val homepage: Any,
    val id: String,
    val keywords: Any,
    val links: Links,
    val max_stable_version: String,
    val max_version: String,
    val name: String,
    val newest_version: String,
    val recent_downloads: Int,
    val repository: String,
    val updated_at: String,
    val versions: Any
)