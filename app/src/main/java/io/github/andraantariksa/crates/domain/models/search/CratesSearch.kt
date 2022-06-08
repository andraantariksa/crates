package io.github.andraantariksa.crates.domain.models.search

import io.github.andraantariksa.crates.domain.models.common.Crate

data class CratesSearch(
    val crates: List<Crate>,
    val meta: Meta
)