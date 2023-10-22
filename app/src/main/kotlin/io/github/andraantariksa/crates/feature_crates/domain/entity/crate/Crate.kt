package io.github.andraantariksa.crates.feature_crates.domain.entity.crate

open class Crate(
    open val name: String,
    open val id: String,
    open val versions: String?,
    open val maxVersion: String,
    open val description: String
) {
    companion object {
        val dummy = Crate(
            name = "bevy bevy bevy",
            id = "bevy",
            versions = "0.9.1",
            maxVersion = "0.9.1",
            description = "A refreshingly simple data-driven game engine and app framework"
        )
    }
}
