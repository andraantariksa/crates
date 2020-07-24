package io.github.andraantariksa.cratesio.data.api

import android.content.Context
import android.net.ConnectivityManager
import io.github.andraantariksa.cratesio.internal.exception.NoConnectivityException
import okhttp3.Interceptor
import okhttp3.Response

class ConnectivityInterceptorImpl(
    context: Context
) : ConnectivityInterceptor {

    private val appContext = context.applicationContext

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isOnline()) {
            throw NoConnectivityException()
        }

        return chain.proceed(chain.request())
    }

    fun isOnline(): Boolean {
        val connectivityManager =
            appContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo ?: return false

        return networkInfo.isConnected
    }
}