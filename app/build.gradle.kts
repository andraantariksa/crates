plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion = "android-32"
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = "io.github.andraantariksa.cratesio"
        minSdkVersion(21)
        targetSdkVersion(32)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Deps.AndroidX.Compose.Version
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    implementation(fileTree("libs") { listOf("*.jar") })

    implementation(Deps.SquareUp.Retrofit.Retrofit)
    implementation(Deps.SquareUp.Retrofit.ConverterMoshi)
    implementation(Deps.SquareUp.Retrofit.ConverterScalars)
    implementation(Deps.SquareUp.Moshi.Moshi)
    kapt(Deps.SquareUp.Moshi.MoshiCodegen)
    implementation(Deps.AndroidX.Hilt.HiltNavigationCompose)
    implementation(Deps.Google.Dagger.HiltAndroid)
    kapt(Deps.Google.Dagger.HiltAndroidCompiler)
    kapt(Deps.Google.Dagger.DaggerAndroidProcessor)
    implementation(Deps.Markwon.Core)
    implementation(Deps.Markwon.ImageCoil)
    implementation(Deps.Google.Firebase.FirebaseAnalyticsKtx)
    implementation(Deps.Google.Firebase.FirebaseCrashlyticsKtx)
    implementation(Deps.AndroidX.Activity.ActivityCompose)
    implementation(Deps.AndroidX.Compose.UI.UITooling)
    implementation(Deps.AndroidX.Compose.UI.UI)
    implementation(Deps.AndroidX.Compose.Material.Material)
    implementation(Deps.AndroidX.Compose.Material.MaterialIconsCore)
    implementation(Deps.AndroidX.Compose.Material.MaterialIconsExtended)
    implementation(Deps.AndroidX.Compose.Foundation.Foundation)
    implementation(Deps.AndroidX.Lifecycle.LifecycleViewmodelCompose)
    implementation(Deps.Google.Android.Material)
    implementation(Deps.AndroidX.Core.CoreKtx)
    implementation(Deps.AndroidX.Navigation.NavigationCompose)
    implementation(Deps.AirBNB.LottieCompose)
    implementation(Deps.SquareUp.OkHttp.LoggingInterceptor)
    implementation(Deps.SquareUp.OkHttp.UrlConnection)
    implementation(Deps.AndroidX.Room.RoomRuntime)
    implementation(Deps.Google.Accompanist.WebView)
    kapt(Deps.AndroidX.Room.RoomCompiler)

    testImplementation(Deps.Mockito.MockitoKotlin)
    testImplementation(Deps.Robolectric.Robolectric)
    testImplementation(Deps.JUnit.JUnit)
    testImplementation(Deps.Google.Truth.Truth)

    androidTestImplementation(Deps.AndroidX.Test.Ext.JUnit)
    androidTestImplementation(Deps.AndroidX.Test.Espresso.EspressoCore)
}