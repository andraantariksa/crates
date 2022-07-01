package io.github.andraantariksa.crates.feature_crates.domain.model.crate

open class Crate(
    open val name: String,
    open val id: String,
    open val versions: String?,
    open val maxVersion: String,
    open val description: String
)
