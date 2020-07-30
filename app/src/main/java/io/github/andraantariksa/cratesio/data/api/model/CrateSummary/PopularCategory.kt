package io.github.andraantariksa.cratesio.data.api.model.CrateSummary


import com.google.gson.annotations.SerializedName
import io.github.andraantariksa.cratesio.ui.ActionType

data class PopularCategory(
    @SerializedName("category")
    var category: String,
    @SerializedName("crates_cnt")
    var cratesCnt: Int,
    @SerializedName("created_at")
    var createdAt: String,
    @SerializedName("description")
    var description: String,
    @SerializedName("id")
    var id: String,
    @SerializedName("slug")
    var slug: String
) : Summary {
    override val title: String
        get() = category

    override val subtitle: String
        get() = "${cratesCnt} crates"

    override val actionTargetName: String
        get() = id

    override val actionType: ActionType
        get() = ActionType.Crates
}
