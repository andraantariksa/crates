package io.github.andraantariksa.crates.feature_crates.domain.entity.summary

import io.github.andraantariksa.crates.feature_crates.data.source.remote.model.summary.*

open class CratesSummary(
    open val justUpdatedCrate: List<JustUpdatedCrate>,
    open val mostDownloaded: List<MostDownloaded>,
    open val mostRecentlyDownloaded: List<MostRecentlyDownloaded>,
    open val newCrates: List<NewCrate>,
    open val numCrates: Int,
    open val numDownloads: Long,
    open val popularCategories: List<PopularCategory>,
    open val popularKeywords: List<PopularKeyword>
)