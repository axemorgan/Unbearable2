import Dependencies.daggerHilt

plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(compileSdk)

    defaultConfig {
        applicationId = "dev.alexmorgan.unbearable2"

        minSdkVersion(minSdk)
        targetSdkVersion(targetSdk)
        versionCode = 1
        versionName = "0.1"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(Kotlin.stdlib)

    implementation(AndroidX.activityKtx)
    implementation(AndroidX.appcompat)
    implementation(AndroidX.constraintLayout)
    implementation(AndroidX.coreKtx)
    implementation(AndroidX.fragmentKtx)
    implementation(AndroidX.hiltViewModel)
    kapt(AndroidX.hiltAndroidxCompiler)
    implementation(AndroidX.recyclerView)

    implementation(Dependencies.glide)

    daggerHilt()
}
