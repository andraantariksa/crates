package io.github.andraantariksa.cratesio.data.models.detail

import io.github.andraantariksa.cratesio.data.models.common.Links

data class Version(
    val audit_actions: List<AuditAction>,
    val crate: String,
    val crate_size: Int,
    val created_at: String,
    val dl_path: String,
    val downloads: Int,
    val features: Any,
    val id: Int,
    val license: String,
    val links: Links,
    val num: String,
    val published_by: PublishedBy,
    val readme_path: String,
    val updated_at: String,
    val yanked: Boolean
)