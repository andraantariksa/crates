package io.github.andraantariksa.cratesio.data.network.model


import com.google.gson.annotations.SerializedName

data class LinksX(
    @SerializedName("owner_team")
    var ownerTeam: String,
    @SerializedName("owner_user")
    var ownerUser: String,
    @SerializedName("owners")
    var owners: String,
    @SerializedName("reverse_dependencies")
    var reverseDependencies: String,
    @SerializedName("version_downloads")
    var versionDownloads: String,
    @SerializedName("versions")
    var versions: String
)