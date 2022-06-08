package io.github.andraantariksa.crates.domain.use_case

import io.github.andraantariksa.crates.domain.models.summary.CratesSummary
import io.github.andraantariksa.crates.domain.repository.CratesIoRepository

class GetCratesSummary(
    private val repository: CratesIoRepository
) {
    suspend operator fun invoke(): CratesSummary {
        return repository.getCratesSummary()
    }
}