package io.github.andraantariksa.cratesio.data.network.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import io.github.andraantariksa.cratesio.data.network.model.CrateSummary.CrateSummary

@Dao
interface CrateSummaryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(crateSummary: CrateSummary)

    fun getCrateSummary(): LiveData<CrateSummary>
}