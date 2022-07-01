package io.github.andraantariksa.crates.feature_crates.data.source.remote.model.search

import io.github.andraantariksa.crates.feature_crates.data.source.remote.model.common.Crate

data class CratesSearch(
    val crates: List<Crate>,
    val meta: Meta
)