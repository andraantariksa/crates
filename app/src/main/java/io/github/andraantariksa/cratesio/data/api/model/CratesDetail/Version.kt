package io.github.andraantariksa.cratesio.data.api.model.CratesDetail


import com.google.gson.annotations.SerializedName

data class Version(
    @SerializedName("audit_actions")
    var auditActions: List<Any>,
    @SerializedName("crate")
    var crate: String,
    @SerializedName("crate_size")
    var crateSize: Int,
    @SerializedName("created_at")
    var createdAt: String,
    @SerializedName("dl_path")
    var dlPath: String,
    @SerializedName("downloads")
    var downloads: Int,
    @SerializedName("features")
    var features: Features,
    @SerializedName("id")
    var id: Int,
    @SerializedName("license")
    var license: String,
    @SerializedName("links")
    var links: LinksX,
    @SerializedName("num")
    var num: String,
    @SerializedName("published_by")
    var publishedBy: PublishedBy,
    @SerializedName("readme_path")
    var readmePath: String,
    @SerializedName("updated_at")
    var updatedAt: String,
    @SerializedName("yanked")
    var yanked: Boolean
)