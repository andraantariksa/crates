package io.github.andraantariksa.crates.common.util

sealed class CratesResult<T> {
    class Loading<T> : CratesResult<T>()
    class Loaded<T>(val data: T) : CratesResult<T>()
    class Error<T>(val error: Throwable) : CratesResult<T>()
}

fun <T> kotlin.Result<T>.toCratesResult(): CratesResult<T> {
    exceptionOrNull()?.let { exception ->
        return CratesResult.Error(exception)
    }
    return CratesResult.Loaded(getOrNull()!!)
}
