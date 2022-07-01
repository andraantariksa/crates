package io.github.andraantariksa.crates.feature_crates.data.source.remote.model.summary

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CratesSummary(
    @Json(name = "just_updated")
    override val justUpdatedCrate: List<JustUpdatedCrate>,
    @Json(name = "most_downloaded")
    override val mostDownloaded: List<MostDownloaded>,
    @Json(name = "most_recently_downloaded")
    override val mostRecentlyDownloaded: List<MostRecentlyDownloaded>,
    @Json(name = "new_crates")
    override val newCrates: List<NewCrate>,
    @Json(name = "num_crates")
    override val numCrates: Int,
    @Json(name = "num_downloads")
    override val numDownloads: Long,
    @Json(name = "popular_categories")
    override val popularCategories: List<PopularCategory>,
    @Json(name = "popular_keywords")
    override val popularKeywords: List<PopularKeyword>,
) : io.github.andraantariksa.crates.feature_crates.domain.model.summary.CratesSummary(
    justUpdatedCrate = justUpdatedCrate,
    mostDownloaded = mostDownloaded,
    mostRecentlyDownloaded = mostRecentlyDownloaded,
    newCrates = newCrates,
    numCrates = numCrates,
    numDownloads = numDownloads,
    popularCategories = popularCategories,
    popularKeywords = popularKeywords
) {
    companion object {
        val example = CratesSummary(
            numCrates = 123,
            numDownloads = 123,
            justUpdatedCrate = listOf(),
            mostDownloaded = listOf(),
            mostRecentlyDownloaded = listOf(),
            newCrates = listOf(),
            popularCategories = listOf(),
            popularKeywords = listOf(),
        )
    }
}