package io.github.andraantariksa.crates.feature_crates.data.source.local.model.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import io.github.andraantariksa.crates.feature_crates.domain.model.user.User

@Entity(
    tableName = "user"
)
data class UserEntity(
    override val userId: Int,
    override val avatar: String,
    override val email: String,
    override val emailVerificationSent: Boolean,
    override val emailVerified: Boolean,
    override val username: String,
    override val name: String,
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
) {
    @PrimaryKey
    var id: Int = 0
}