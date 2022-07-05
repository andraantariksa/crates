package io.github.andraantariksa.crates.feature_crates.data.source.local.model.cookie

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "cookie",
    indices = [
        Index(
            value = ["domain", "name"],
            unique = true
        )
    ]
)
data class CookieEntity(
    val value: String,
    val host: String,
    val expiresAt: Long,
    val domain: String,
    val name: String,
    val hostOnly: Boolean,
    val path: String,
    val httpOnly: Boolean,
    val secure: Boolean,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}