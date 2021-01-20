package io.github.andraantariksa.cratesio.data.models.summary

data class CratesSummary(
    val just_updated: List<JustUpdated>,
    val most_downloaded: List<MostDownloaded>,
    val most_recently_downloaded: List<MostRecentlyDownloaded>,
    val new_crates: List<NewCrate>,
    val num_crates: Int,
    val num_downloads: Long,
    val popular_categories: List<PopularCategory>,
    val popular_keywords: List<PopularKeyword>
)