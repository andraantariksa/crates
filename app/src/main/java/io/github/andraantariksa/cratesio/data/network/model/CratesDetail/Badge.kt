package io.github.andraantariksa.cratesio.data.network.model.CratesDetail


import com.google.gson.annotations.SerializedName

data class Badge(
    @SerializedName("attributes")
    var attributes: Attributes,
    @SerializedName("badge_type")
    var badgeType: String
)