package io.github.andraantariksa.crates.feature_crates.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.github.andraantariksa.crates.feature_crates.data.repository.CookieRepositoryImpl
import io.github.andraantariksa.crates.feature_crates.data.repository.CratesIoRepositoryImpl
import io.github.andraantariksa.crates.feature_crates.data.repository.UserRepositoryImpl
import io.github.andraantariksa.crates.feature_crates.data.source.local.CratesIoDataSourceLocal
import io.github.andraantariksa.crates.feature_crates.data.source.local.CratesIoDataSourceLocalImpl
import io.github.andraantariksa.crates.feature_crates.data.source.local.UserDataSourceLocal
import io.github.andraantariksa.crates.feature_crates.data.source.local.UserDataSourceLocalImpl
import io.github.andraantariksa.crates.feature_crates.data.source.local.database.CratesDatabase
import io.github.andraantariksa.crates.feature_crates.data.source.remote.CratesIoDataSourceRemote
import io.github.andraantariksa.crates.feature_crates.data.source.remote.CratesIoDataSourceRemoteImpl
import io.github.andraantariksa.crates.feature_crates.data.source.remote.service.ConnectivityInterceptor
import io.github.andraantariksa.crates.feature_crates.data.source.remote.service.CratesIoAPIService
import io.github.andraantariksa.crates.feature_crates.domain.repository.CookieRepository
import io.github.andraantariksa.crates.feature_crates.domain.repository.CratesIoRepository
import io.github.andraantariksa.crates.feature_crates.domain.repository.UserRepository
import io.github.andraantariksa.crates.feature_crates.util.PersistedCookieJar
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideCratesDatabase(@ApplicationContext context: Context): CratesDatabase =
        Room
            .databaseBuilder(context, CratesDatabase::class.java, CratesDatabase.NAME)
            .build()

    @Singleton
    @Provides
    fun provideCookieRepository(cratesDatabase: CratesDatabase): CookieRepository =
        CookieRepositoryImpl(cratesDatabase)

    @Singleton
    @Provides
    fun provideCratesioAPIService(
        @ApplicationContext context: Context,
        cookieRepository: CookieRepository
    ): CratesIoAPIService {
        val okHttpClient = OkHttpClient.Builder()
//            .addInterceptor {
//                var requestBuilder = it.request().newBuilder()
//                runBlocking {
//                    userDataSourceLocal.get().first()?.let { myUser ->
//                        requestBuilder =
//                            requestBuilder.header("cookie", "cargo_session=${myUser.session}")
//                    }
//                }
//                it.proceed(requestBuilder.build())
//            }
            .addInterceptor(ConnectivityInterceptor(context))
            .cookieJar(PersistedCookieJar(cookieRepository = cookieRepository))
            .build()

        return Retrofit.Builder().client(okHttpClient).baseUrl("https://crates.io/api/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create()).build()
            .create(CratesIoAPIService::class.java)
    }

    @Singleton
    @Provides
    fun provideCratesIoDataSourceRemote(cratesioAPIService: CratesIoAPIService): CratesIoDataSourceRemote =
        CratesIoDataSourceRemoteImpl(cratesioAPIService)

    @Singleton
    @Provides
    fun provideUserRepository(
        cratesIoDataSourceRemote: CratesIoDataSourceRemote,
        userDataSourceLocal: UserDataSourceLocal,
    ): UserRepository = UserRepositoryImpl(
        cratesIoDataSourceRemote = cratesIoDataSourceRemote,
        userDataSourceLocal = userDataSourceLocal
    )

    @Singleton
    @Provides
    fun provideCratesIoDataSourceLocal(): CratesIoDataSourceLocal = CratesIoDataSourceLocalImpl()

    @Singleton
    @Provides
    fun provideUserDataSourceLocal(cratesDatabase: CratesDatabase): UserDataSourceLocal =
        UserDataSourceLocalImpl(cratesDatabase = cratesDatabase)

    @Singleton
    @Provides
    fun provideCratesIoRepository(
        cratesIoDatasourceRemote: CratesIoDataSourceRemote,
        cratesIoDatasourceLocal: CratesIoDataSourceLocal
    ): CratesIoRepository = CratesIoRepositoryImpl(
        cratesIoDatasourceLocal = cratesIoDatasourceLocal,
        cratesIoDatasourceRemote = cratesIoDatasourceRemote
    )
}