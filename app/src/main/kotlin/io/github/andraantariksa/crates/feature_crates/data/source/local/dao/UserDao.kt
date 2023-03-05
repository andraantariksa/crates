package io.github.andraantariksa.crates.feature_crates.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.github.andraantariksa.crates.feature_crates.data.source.local.model.user.MyUserDBEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(user: MyUserDBEntity)

    @Query("SELECT * FROM my_user WHERE id = 1")
    fun get(): Flow<MyUserDBEntity?>

    @Query("DELETE FROM my_user WHERE id = 1")
    suspend fun remove()
}