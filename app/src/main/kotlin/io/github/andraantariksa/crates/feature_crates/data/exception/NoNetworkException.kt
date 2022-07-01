package io.github.andraantariksa.crates.feature_crates.data.exception

class NoNetworkException: RuntimeException() {
    override fun equals(other: Any?): Boolean {
        return other is NoNetworkException
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }
}