package io.github.andraantariksa.cratesio.data.models.detail

data class AuditAction(
    val action: String,
    val time: String,
    val user: User
)