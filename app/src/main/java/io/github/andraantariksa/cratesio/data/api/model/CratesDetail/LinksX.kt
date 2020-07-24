package io.github.andraantariksa.cratesio.data.api.model.CratesDetail


import com.google.gson.annotations.SerializedName

data class LinksX(
    @SerializedName("authors")
    var authors: String,
    @SerializedName("dependencies")
    var dependencies: String,
    @SerializedName("version_downloads")
    var versionDownloads: String
)