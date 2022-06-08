package io.github.andraantariksa.crates.domain.models.summary


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CratesSummary(
    @Json(name = "just_updated")
    val justUpdated: List<JustUpdated>,
    @Json(name = "most_downloaded")
    val mostDownloaded: List<MostDownloaded>,
    @Json(name = "most_recently_downloaded")
    val mostRecentlyDownloaded: List<MostRecentlyDownloaded>,
    @Json(name = "new_crates")
    val newCrates: List<NewCrate>,
    @Json(name = "num_crates")
    val numCrates: Int,
    @Json(name = "num_downloads")
    val numDownloads: Long,
    @Json(name = "popular_categories")
    val popularCategories: List<PopularCategory>,
    @Json(name = "popular_keywords")
    val popularKeywords: List<PopularKeyword>
)