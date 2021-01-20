package io.github.andraantariksa.cratesio.data.models.search

import io.github.andraantariksa.cratesio.data.models.common.Crate

data class CratesSearch(
    val crates: List<Crate>,
    val meta: Meta
)