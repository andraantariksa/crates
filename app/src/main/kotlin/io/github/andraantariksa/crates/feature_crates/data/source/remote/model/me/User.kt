package io.github.andraantariksa.crates.feature_crates.data.source.remote.model.me


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.github.andraantariksa.crates.feature_crates.domain.model.user.User

@JsonClass(generateAdapter = true)
data class User(
    @Json(name = "avatar")
    override val avatar: String,
    @Json(name = "email")
    override val email: String,
    @Json(name = "email_verification_sent")
    override val emailVerificationSent: Boolean,
    @Json(name = "email_verified")
    override val emailVerified: Boolean,
    @Json(name = "id")
    override val userId: Int,
    @Json(name = "login")
    override val username: String,
    @Json(name = "name")
    override val name: String,
    @Json(name = "url")
    override val url: String
) : User(
    userId = userId,
    avatar = avatar,
    email = email,
    username = username,
    name = name,
    url = url,
    emailVerificationSent = emailVerificationSent,
    emailVerified = emailVerified,
)