package io.github.andraantariksa.crates.feature_crates.domain.repository

import okhttp3.Cookie
import okhttp3.CookieJar

interface CookieRepository {
    suspend fun insert(host: String, cookies: List<Cookie>)
    suspend fun get(host: String): List<Cookie>
    suspend fun remove(host: String)
}