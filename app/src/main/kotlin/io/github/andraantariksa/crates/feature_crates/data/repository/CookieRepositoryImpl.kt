package io.github.andraantariksa.crates.feature_crates.data.repository

import io.github.andraantariksa.crates.feature_crates.data.source.local.database.CratesDatabase
import io.github.andraantariksa.crates.feature_crates.data.source.local.model.cookie.CookieEntity
import io.github.andraantariksa.crates.feature_crates.domain.repository.CookieRepository
import okhttp3.Cookie

class CookieRepositoryImpl(cratesDatabase: CratesDatabase) : CookieRepository {
    private val cookieDao = cratesDatabase.cookieDao()

    override suspend fun insert(host: String, cookies: List<Cookie>) {
        val cookieEntities = cookies
            .map { cookie ->
                CookieEntity(
                    host = host,
                    hostOnly = cookie.hostOnly,
                    domain = cookie.domain,
                    expiresAt = cookie.expiresAt,
                    path = cookie.path,
                    httpOnly = cookie.httpOnly,
                    secure = cookie.secure,
                    name = cookie.name,
                    value = cookie.value
                )
            }
        cookieDao.add(cookieEntities)
    }

    override suspend fun get(host: String): List<Cookie> {
        return cookieDao.get(host).map { cookie ->
            var cookieBuilder = Cookie.Builder()
                .expiresAt(cookie.expiresAt)
                .path(cookie.path)
                .name(cookie.name)
                .value(cookie.value)
            if (cookie.httpOnly) {
                cookieBuilder = cookieBuilder.httpOnly()
            }
            cookieBuilder = if (cookie.hostOnly) {
                cookieBuilder.hostOnlyDomain(cookie.domain)
            } else {
                cookieBuilder.domain(cookie.domain)
            }
            if (cookie.secure) {
                cookieBuilder = cookieBuilder.secure()
            }
            cookieBuilder.build()
        }
    }

    override suspend fun remove(host: String) {
        cookieDao.remove(host)
    }
}