package io.github.andraantariksa.crates.feature_crates.data.source.local.converter

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import io.github.andraantariksa.crates.feature_crates.data.source.local.model.crates_summary.CratesSummaryEntity
import io.github.andraantariksa.crates.feature_crates.data.source.remote.model.summary.CratesSummary

class MoshiConverter {
    lateinit var moshi: Moshi
    private val cratesSummaryAdapter = moshi.adapter(CratesSummary::class.java)

    @TypeConverter
    fun stringToCratesSummary(string: String): CratesSummary {
        return cratesSummaryAdapter.fromJson(string) ?: throw IllegalStateException()
    }

    @TypeConverter
    fun cratesSummaryToString(cratesSummaryEntity: CratesSummary): String {
        return cratesSummaryAdapter.toJson(cratesSummaryEntity)
    }
}