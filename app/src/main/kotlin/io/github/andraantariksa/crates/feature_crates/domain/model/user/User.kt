package io.github.andraantariksa.crates.feature_crates.domain.model.user

import io.github.andraantariksa.crates.feature_crates.data.source.local.model.user.UserEntity

open class User(
    open val userId: Int,
    open val avatar: String,
    open val email: String,
    open val emailVerificationSent: Boolean,
    open val emailVerified: Boolean,
    open val username: String,
    open val name: String,
    open val url: String
) {
    fun toUserEntity() = UserEntity(
        userId = userId,
        avatar = avatar,
        email = email,
        emailVerificationSent = emailVerificationSent,
        emailVerified = emailVerified,
        username = username,
        name = name,
        url = url,
    )
}