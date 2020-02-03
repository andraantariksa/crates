package io.github.andraantariksa.cratesio.data.network.model


import com.google.gson.annotations.SerializedName

data class PopularKeyword(
    @SerializedName("crates_cnt")
    var cratesCnt: Int,
    @SerializedName("created_at")
    var createdAt: String,
    @SerializedName("id")
    var id: String,
    @SerializedName("keyword")
    var keyword: String
)