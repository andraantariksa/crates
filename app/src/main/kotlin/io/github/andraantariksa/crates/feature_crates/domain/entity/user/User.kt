package io.github.andraantariksa.crates.feature_crates.domain.entity.user

open class User(
    open val userId: Int,
    open val avatar: String?,
    open val email: String,
    open val emailVerificationSent: Boolean,
    open val emailVerified: Boolean,
    open val username: String,
    open val name: String,
    open val url: String,
)