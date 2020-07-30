package io.github.andraantariksa.cratesio.data.api.model.CrateSummary


import com.google.gson.annotations.SerializedName
import io.github.andraantariksa.cratesio.ui.ActionType

data class NewCrate(
    @SerializedName("badges")
    var badges: Any,
    @SerializedName("categories")
    var categories: Any,
    @SerializedName("created_at")
    var createdAt: String,
    @SerializedName("description")
    var description: String,
    @SerializedName("documentation")
    var documentation: String,
    @SerializedName("downloads")
    var downloads: Int,
    @SerializedName("exact_match")
    var exactMatch: Boolean,
    @SerializedName("homepage")
    var homepage: String,
    @SerializedName("id")
    var id: String,
    @SerializedName("keywords")
    var keywords: Any,
    @SerializedName("links")
    var links: Links,
    @SerializedName("max_version")
    var maxVersion: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("newest_version")
    var newestVersion: String,
    @SerializedName("recent_downloads")
    var recentDownloads: Any,
    @SerializedName("repository")
    var repository: String,
    @SerializedName("updated_at")
    var updatedAt: String,
    @SerializedName("versions")
    var versions: Any
) : Summary {
    override val title: String
        get() = name

    override val subtitle: String
        get() = maxVersion

    override val actionTargetName: String
        get() = id

    override val actionType: ActionType
        get() = ActionType.Crates
}
