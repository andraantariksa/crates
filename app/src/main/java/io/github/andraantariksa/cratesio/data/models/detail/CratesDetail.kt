package io.github.andraantariksa.cratesio.data.models.detail

import io.github.andraantariksa.cratesio.data.models.common.Crate

data class CratesDetail(
    val categories: List<Category>,
    val crate: Crate,
    val keywords: List<Keyword>,
    val versions: List<Version>
)