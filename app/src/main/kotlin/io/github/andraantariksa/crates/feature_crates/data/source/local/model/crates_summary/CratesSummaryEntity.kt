package io.github.andraantariksa.crates.feature_crates.data.source.local.model.crates_summary

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import io.github.andraantariksa.crates.feature_crates.data.source.remote.model.summary.*

@JsonClass(generateAdapter = true)
@Entity(tableName = "crates_summary")
data class CratesSummaryEntity(
    @PrimaryKey
    val id: Int = 1,
    val cratesSummary: CratesSummary,
)