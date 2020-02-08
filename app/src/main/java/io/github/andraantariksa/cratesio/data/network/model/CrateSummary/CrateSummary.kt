package io.github.andraantariksa.cratesio.data.network.model.CrateSummary


import com.google.gson.annotations.SerializedName

data class CrateSummary(
    @SerializedName("just_updated")
    var justUpdated: List<JustUpdated>,
    @SerializedName("most_downloaded")
    var mostDownloaded: List<MostDownloaded>,
    @SerializedName("most_recently_downloaded")
    var mostRecentlyDownloaded: List<MostRecentlyDownloaded>,
    @SerializedName("new_crates")
    var newCrates: List<NewCrate>,
    @SerializedName("num_crates")
    var numCrates: Int,
    @SerializedName("num_downloads")
    var numDownloads: Long,
    @SerializedName("popular_categories")
    var popularCategories: List<PopularCategory>,
    @SerializedName("popular_keywords")
    var popularKeywords: List<PopularKeyword>
)