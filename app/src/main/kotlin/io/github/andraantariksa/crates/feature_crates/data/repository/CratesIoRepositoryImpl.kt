package io.github.andraantariksa.crates.feature_crates.data.repository

import io.github.andraantariksa.crates.feature_crates.data.exception.NoCachedDataException
import io.github.andraantariksa.crates.feature_crates.data.exception.NoNetworkException
import io.github.andraantariksa.crates.feature_crates.data.source.local.CratesIoDataSourceLocal
import io.github.andraantariksa.crates.feature_crates.data.source.remote.CratesIoDataSourceRemote
import io.github.andraantariksa.crates.feature_crates.data.source.remote.model.detail.CrateDetail
import io.github.andraantariksa.crates.feature_crates.data.source.remote.model.sign_in.AuthBegin
import io.github.andraantariksa.crates.feature_crates.domain.entity.summary.CratesSummary
import io.github.andraantariksa.crates.feature_crates.domain.entity.user.User
import io.github.andraantariksa.crates.feature_crates.domain.repository.CratesIoRepository
import javax.inject.Inject

class CratesIoRepositoryImpl @Inject constructor(
    private val cratesIoDatasourceRemote: CratesIoDataSourceRemote,
    private val cratesIoDatasourceLocal: CratesIoDataSourceLocal,
) : CratesIoRepository {
    override suspend fun getCratesSummary(): Result<CratesSummary> {
        var result = try {
            Result.success(cratesIoDatasourceRemote.getCratesSummary())
        } catch (exception: NoNetworkException) {
            Result.failure(exception)
        } catch (exception: Exception) {
            Result.failure(exception)
        }

        if (result.isFailure) {
            try {
                result = Result.success(cratesIoDatasourceLocal.getCratesSummary())
            } catch (exception: NoCachedDataException) {
//                Its better to just show network failure when there is no cached data
//                Result.failure(exception)
            } catch (exception: Exception) {
                result = Result.failure(exception)
            }
        }

        return result
    }

    override suspend fun getCrateDetails(id: Int): Result<CrateDetail> {
        var result = try {
            Result.success(cratesIoDatasourceRemote.getCrateDetail(id))
        } catch (exception: NoNetworkException) {
            Result.failure(exception)
        } catch (exception: Exception) {
            Result.failure(exception)
        }

        if (result.isFailure) {
            try {
                result = Result.success(cratesIoDatasourceRemote.getCrateDetail(id))
            } catch (exception: NoCachedDataException) {
//                Its better to just show network failure when there is no cached data
//                Result.failure(exception)
            } catch (exception: Exception) {
                result = Result.failure(exception)
            }
        }

        return result
    }

    override suspend fun getBeginAuthData(): AuthBegin = cratesIoDatasourceRemote.getBeginAuthData()

    override suspend fun authorizeOauth(code: String, state: String): Result<User> = try {
        Result.success(cratesIoDatasourceRemote.authorizeOauth(code, state).user)
    } catch (exception: Exception) {
        Result.failure(exception)
    }
}
