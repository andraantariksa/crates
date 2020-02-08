package io.github.andraantariksa.cratesio.data.network.model.CratesDetail


import com.google.gson.annotations.SerializedName

data class CratesDetail(
    @SerializedName("categories")
    var categories: List<Category>,
    @SerializedName("crate")
    var crate: Crate,
    @SerializedName("keywords")
    var keywords: List<Keyword>,
    @SerializedName("versions")
    var versions: List<Version>
)