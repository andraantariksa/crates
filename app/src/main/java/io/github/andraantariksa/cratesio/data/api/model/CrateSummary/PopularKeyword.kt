package io.github.andraantariksa.cratesio.data.api.model.CrateSummary


import com.google.gson.annotations.SerializedName
import io.github.andraantariksa.cratesio.ui.ActionType

data class PopularKeyword(
    @SerializedName("crates_cnt")
    var cratesCnt: Int,
    @SerializedName("created_at")
    var createdAt: String,
    @SerializedName("id")
    var id: String,
    @SerializedName("keyword")
    var keyword: String
) : Summary {
    override val title: String
        get() = keyword

    override val subtitle: String
        get() = "${cratesCnt} crates"

    override val actionTargetName: String
        get() = id

    override val actionType: ActionType
        get() = ActionType.Crates
}
