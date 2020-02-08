package io.github.andraantariksa.cratesio.data.network.model.CratesDetail


import com.google.gson.annotations.SerializedName

data class Attributes(
    @SerializedName("branch")
    var branch: Any,
    @SerializedName("repository")
    var repository: String
)