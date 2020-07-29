package io.github.andraantariksa.cratesio.data.db.entity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import io.github.andraantariksa.cratesio.data.api.model.CrateSummary.CrateSummary

@Entity(tableName = "crates_summary", indices = [Index(value = ["date"], unique = true)])
data class CratesSummaryEntry(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val crateSummary: CrateSummary,
    val date: String
) {
    fun getCrateSummaryLiveData(): LiveData<CrateSummary> {
        return MutableLiveData<CrateSummary>(crateSummary)
    }
}
