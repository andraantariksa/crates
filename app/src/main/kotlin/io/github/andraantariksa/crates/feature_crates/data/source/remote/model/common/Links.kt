package io.github.andraantariksa.crates.feature_crates.data.source.remote.model.common

data class Links(
    val owner_team: String,
    val owner_user: String,
    val owners: String,
    val reverse_dependencies: String,
    val version_downloads: String,
    val versions: String
)