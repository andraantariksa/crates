package io.github.andraantariksa.crates.feature_crates.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.github.andraantariksa.crates.feature_crates.data.source.local.model.cookie.CookieEntity

@Dao
interface CookieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(cookies: List<CookieEntity>)

    @Query("SELECT * FROM cookie WHERE host = :host")
    suspend fun get(host: String): List<CookieEntity>

    @Query("DELETE FROM cookie WHERE host = :host")
    suspend fun remove(host: String)

    @Query("DELETE FROM cookie")
    suspend fun removeAll()
}