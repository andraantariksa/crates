package io.github.andraantariksa.crates.feature_crates.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.github.andraantariksa.crates.feature_crates.data.source.local.model.user.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(user: UserEntity)

    @Query("SELECT * FROM user WHERE id = 0")
    fun get(): Flow<UserEntity?>

    @Query("DELETE FROM user WHERE id = 0")
    suspend fun remove()
}