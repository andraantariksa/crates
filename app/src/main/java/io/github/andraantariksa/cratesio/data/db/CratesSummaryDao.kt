package io.github.andraantariksa.cratesio.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.github.andraantariksa.cratesio.data.db.entity.CratesSummaryEntry
import java.time.LocalDateTime

@Dao
interface CratesSummaryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entry: CratesSummaryEntry)

    @Query("DELETE FROM crates_summary where date(date) < date(:firstDateToKeep)")
    fun deleteCrateSummary(firstDateToKeep: LocalDateTime)

    @Query("SELECT * FROM crates_summary ORDER BY date DESC LIMIT 1")
    fun getCrateSummaryLast(): CratesSummaryEntry?
}
