package io.github.andraantariksa.crates.feature_crates.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import io.github.andraantariksa.crates.feature_crates.data.source.local.converter.MoshiConverter
import io.github.andraantariksa.crates.feature_crates.data.source.local.dao.CratesSummaryDao
import io.github.andraantariksa.crates.feature_crates.data.source.local.model.crates_summary.CratesSummaryEntity

@Database(entities = [CratesSummaryEntity::class], version = 1)
@TypeConverters(MoshiConverter::class)
abstract class CratesDatabase : RoomDatabase() {
    abstract fun crateSummaryDao(): CratesSummaryDao

    companion object {
        const val NAME = "crates"
    }
}