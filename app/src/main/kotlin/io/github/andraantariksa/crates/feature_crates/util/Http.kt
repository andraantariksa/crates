package io.github.andraantariksa.crates.feature_crates.util

fun parseCookie(rawValue: String): Map<String, String> {
    val map = mutableMapOf<String, String>()

    val keyValues = rawValue.split(';')
    keyValues.forEach {  rawKeyValue ->
        val keyValue = rawKeyValue.split('=')
        val key = keyValue.firstOrNull()
        if (key != null) {
            val value = keyValue.lastOrNull() ?: ""
            map[key] = value
        }
    }

    return map
}