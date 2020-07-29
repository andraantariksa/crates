package io.github.andraantariksa.cratesio.data.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import io.github.andraantariksa.cratesio.data.api.model.CrateSummary.CrateSummary
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object Converter {
    private val gson = Gson()

    @TypeConverter
    @JvmStatic
    fun stringToLocalDateTime(chrs: String?): LocalDateTime? = chrs?.let {
        LocalDateTime.parse(it, DateTimeFormatter.ISO_LOCAL_DATE_TIME)
    }

    @TypeConverter
    @JvmStatic
    fun localDateTimeToString(localDateTime: LocalDateTime?): String? {
        return localDateTime?.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
    }

    @TypeConverter
    @JvmStatic
    fun cratesSummaryEntryToString(crateSummaryEntry: CrateSummary?): String? =
        crateSummaryEntry?.let {
            gson.toJson(it)
        }

    @TypeConverter
    @JvmStatic
    fun stringToCratesSummaryEntry(str: String?): CrateSummary? =
        str?.let {
            gson.fromJson(str, CrateSummary::class.java)
        }
}