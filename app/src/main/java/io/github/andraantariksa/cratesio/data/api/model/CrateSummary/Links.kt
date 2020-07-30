package io.github.andraantariksa.cratesio.data.api.model.CrateSummary

import com.google.gson.annotations.SerializedName

data class Links(
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