package io.github.andraantariksa.cratesio.data.api.model.CratesDetail


import com.google.gson.annotations.SerializedName

data class PublishedBy(
    @SerializedName("avatar")
    var avatar: String,
    @SerializedName("id")
    var id: Int,
    @SerializedName("login")
    var login: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)