package io.github.andraantariksa.cratesio.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import io.github.andraantariksa.cratesio.data.db.entity.CratesSummaryEntry

@Database(
    entities = [CratesSummaryEntry::class],
    version = 1
)
@TypeConverters(Converter::class)
abstract class CratesDatabase : RoomDatabase() {
    abstract fun crateSummary(): CratesSummaryDao

    companion object {
        @Volatile
        private var instance: CratesDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                CratesDatabase::class.java, "cratesio.db"
            )
                .build()
    }
}
