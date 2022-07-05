package io.github.andraantariksa.crates.feature_crates.util

import io.github.andraantariksa.crates.feature_crates.domain.repository.CookieRepository
import kotlinx.coroutines.runBlocking
import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl

class PersistedCookieJar(private val cookieRepository: CookieRepository) :
    CookieJar {
    override fun loadForRequest(url: HttpUrl): List<Cookie> = runBlocking {
        cookieRepository.get(url.host)
    }

    override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) = runBlocking {
        cookieRepository.insert(url.host, cookies)
    }
}