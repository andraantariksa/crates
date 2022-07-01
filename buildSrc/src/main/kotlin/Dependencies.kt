@Suppress("MemberVisibilityCanBePrivate", "SpellCheckingInspection")
object Deps {
    const val KotlinVersion = "1.6.10"

    object Android {
        object BuildTools {
            const val Version = "7.2.1"
            const val Gradle = "com.android.tools.build:gradle:$Version"
        }
    }

    object JetBrains {
        const val KotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$KotlinVersion"
    }

    object Markwon {
        const val Version = "4.6.2"
        const val Core = "io.noties.markwon:core:$Version"
        const val ImageCoil = "io.noties.markwon:image-coil:$Version"
    }

    object AndroidX {
        object Room {
            const val Version = "2.4.2"
            const val RoomRuntime = "androidx.room:room-runtime:$Version"
            const val RoomCompiler = "androidx.room:room-compiler:$Version"
        }

        object Activity {
            const val Version = "1.4.0"
            const val ActivityCompose = "androidx.activity:activity-compose:$Version"
        }

        object Lifecycle {
            const val Version = "2.4.1"
            const val LifecycleViewmodelCompose =
                "androidx.lifecycle:lifecycle-viewmodel-compose:$Version"
        }

        object Test {
            object Ext {
                const val Version = "1.1.3"
                const val JUnit = "androidx.test.ext:junit:$Version"
            }

            object Espresso {
                const val Version = "3.4.0"
                const val EspressoCore = "androidx.test.espresso:espresso-core:$Version"
            }
        }

        object Compose {
            const val Version = "1.1.1"

            object UI {
                const val UITooling = "androidx.compose.ui:ui-tooling:$Version"
                const val UI = "androidx.compose.ui:ui:$Version"
            }

            object Material {
                const val Material = "androidx.compose.material:material:$Version"
                const val MaterialIconsCore =
                    "androidx.compose.material:material-icons-core:$Version"
                const val MaterialIconsExtended =
                    "androidx.compose.material:material-icons-extended:$Version"
            }

            object Foundation {
                const val Foundation = "androidx.compose.foundation:foundation:$Version"
            }
        }

        object Core {
            const val Version = "1.8.0"
            const val CoreKtx = "androidx.core:core-ktx:$Version"
        }

        object Hilt {
            const val Version = "1.0.0"
            const val HiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:$Version"
        }

        object Navigation {
            const val Version = "2.5.0-rc02"
            const val NavigationCompose = "androidx.navigation:navigation-compose:$Version"
        }
    }

    object AirBNB {
        const val Version = "5.2.0"
        const val LottieCompose = "com.airbnb.android:lottie-compose:$Version"
    }

    object Google {
        object Accompanist {
            const val Version = "0.24.13-rc"
            const val WebView = "com.google.accompanist:accompanist-webview:$Version"
        }

        object Dagger {
            const val Version = "2.42"
            const val HiltAndroid = "com.google.dagger:hilt-android:$Version"
            const val HiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:$Version"
            const val DaggerAndroidProcessor = "com.google.dagger:dagger-android-processor:$Version"
            const val HiltAndroidGradlePlugin =
                "com.google.dagger:hilt-android-gradle-plugin:$Version"
        }

        object Truth {
            const val Version = "1.1.3"
            const val Truth = "com.google.truth:truth:$Version"
        }

        object Firebase {
            const val FirebaseCrashlyticsKtx =
                "com.google.firebase:firebase-crashlytics-ktx:18.2.11"
            const val FirebaseAnalyticsKtx = "com.google.firebase:firebase-analytics-ktx:21.0.0"
        }

        object Android {
            const val Version = "1.7.0-alpha02"
            const val Material = "com.google.android.material:material:$Version"
        }
    }

    object SquareUp {
        object Retrofit {
            const val Version = "2.9.0"
            const val Retrofit = "com.squareup.retrofit2:retrofit:$Version"
            const val ConverterMoshi = "com.squareup.retrofit2:converter-moshi:$Version"
            const val ConverterScalars = "com.squareup.retrofit2:converter-scalars:$Version"
        }

        object Moshi {
            const val Version = "1.13.0"
            const val Moshi = "com.squareup.moshi:moshi:$Version"
            const val MoshiCodegen = "com.squareup.moshi:moshi-kotlin-codegen:$Version"
        }

        object OkHttp {
            const val LoggingInterceptorVersion = "4.9.3"
            const val LoggingInterceptor =
                "com.squareup.okhttp3:logging-interceptor:$LoggingInterceptorVersion"

            const val UrlConnectionVersion = "4.9.0"
            const val UrlConnection =
                "com.squareup.okhttp3:okhttp-urlconnection:$UrlConnectionVersion"
        }
    }

    object Mockito {
        const val Version = "4.0.0"
        const val MockitoKotlin = "org.mockito.kotlin:mockito-kotlin:$Version"
    }

    object JUnit {
        const val Version = "4.13.2"
        const val JUnit = "junit:junit:$Version"
    }

    object Robolectric {
        const val Version = "4.8.1"
        const val Robolectric = "org.robolectric:robolectric:$Version"
    }
}