package io.github.andraantariksa.cratesio.data.network.model.CrateSummary


import com.google.gson.annotations.SerializedName

data class PopularCategory(
    @SerializedName("category")
    var category: String,
    @SerializedName("crates_cnt")
    var cratesCnt: Int,
    @SerializedName("created_at")
    var createdAt: String,
    @SerializedName("description")
    var description: String,
    @SerializedName("id")
    var id: String,
    @SerializedName("slug")
    var slug: String
)