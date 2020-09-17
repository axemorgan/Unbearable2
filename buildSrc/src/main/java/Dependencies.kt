@file:Suppress("MemberVisibilityCanBePrivate")

import org.gradle.kotlin.dsl.DependencyHandlerScope

const val compileSdk = 30
const val minSdk = 23
const val targetSdk = 29

/**
 * org.jetbrains.kotlin dependencies
 */
object Kotlin {
    const val version = "1.4.10"

    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$version"
}

/**
 * androidx dependencies
 */
object AndroidX {
    private object Versions {
        const val appcompat = "1.1.0"
        const val biometric = "1.0.1"
        const val browser = "1.2.0"
        const val cardView = "1.0.0"
        const val constraintLayout = "2.0.0"
        const val coordinatorLayout = "1.1.0"
        const val core = "1.3.1"
        const val lifecycle = "2.2.0"
        const val recyclerView = "1.1.0"
        const val room = "2.2.5"
    }

    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val biometric = "androidx.biometric:biometric:${Versions.biometric}"
    const val browser = "androidx.browser:browser:${Versions.browser}"
    const val cardView = "androidx.cardview:cardview:${Versions.cardView}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.core}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val coordinatorLayout = "androidx.coordinatorlayout:coordinatorlayout:${Versions.coordinatorLayout}"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$${Versions.lifecycle}"

    /**
     * Configures all the required dependencies for Room
     */
    fun DependencyHandlerScope.room() {
        add("implementation", roomRuntime)
        add("implementation", roomKtx)
        add("kapt", roomCompiler)
    }
}

object Dependencies {
    private object Versions {
        const val dagger = "2.29.1"
    }

    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val daggerAndroid = "com.google.dagger:dagger-android:${Versions.dagger}"
    const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    const val daggerAndroidProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"

    /**
     * Configures all the required dependencies for Dagger Android
     */
    fun DependencyHandlerScope.daggerAndroid() {
        add("implementation", dagger)
        add("kapt", daggerCompiler)
        add("implementation", daggerAndroid)
        add("implementation", daggerAndroidSupport)
        add("kapt", daggerAndroidProcessor)
    }
}
