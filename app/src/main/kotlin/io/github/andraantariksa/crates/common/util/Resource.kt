package io.github.andraantariksa.crates.common.util

sealed class Resource<T> {
    class Loading<T> : Resource<T>()
    class Loaded<T>(val data: T) : Resource<T>()
    class Error<T>(val error: Throwable) : Resource<T>()
}

fun <T>Result<T>.mapToResource(): Resource<T> {
    exceptionOrNull()?.let { exception ->
        return Resource.Error(exception)
    }
    return Resource.Loaded(getOrNull()!!)
}
