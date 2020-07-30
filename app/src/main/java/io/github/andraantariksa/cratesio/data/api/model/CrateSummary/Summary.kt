package io.github.andraantariksa.cratesio.data.api.model.CrateSummary

import io.github.andraantariksa.cratesio.ui.ActionType

interface Summary {
    val title: String
    val subtitle: String
    val actionType: ActionType
    val actionTargetName: String
}
