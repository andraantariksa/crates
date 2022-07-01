package io.github.andraantariksa.crates.feature_crates.domain.use_case

import io.github.andraantariksa.crates.feature_crates.domain.model.summary.CratesSummary
import io.github.andraantariksa.crates.feature_crates.domain.repository.CratesIoRepository

class GetCratesSummary(
    private val repository: CratesIoRepository
) {
    suspend operator fun invoke(): Result<CratesSummary> = repository.getCratesSummary()
}