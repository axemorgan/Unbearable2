@file:Suppress("MemberVisibilityCanBePrivate")

import AndroidX.hiltAndroidxCompiler
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
        const val activity = "1.1.0"
        const val appcompat = "1.1.0"
        const val biometric = "1.0.1"
        const val browser = "1.2.0"
        const val cardView = "1.0.0"
        const val constraintLayout = "2.0.0"
        const val coordinatorLayout = "1.1.0"
        const val core = "1.3.1"
        const val fragment = "1.2.5"
        const val hiltAndroidx = "1.0.0-alpha01"
        const val lifecycle = "2.2.0"
        const val recyclerView = "1.1.0"
        const val room = "2.2.5"
    }

    const val activityKtx = "androidx.activity:activity-ktx:${Versions.activity}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val biometric = "androidx.biometric:biometric:${Versions.biometric}"
    const val browser = "androidx.browser:browser:${Versions.browser}"
    const val cardView = "androidx.cardview:cardview:${Versions.cardView}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.core}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val coordinatorLayout = "androidx.coordinatorlayout:coordinatorlayout:${Versions.coordinatorLayout}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    const val hiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltAndroidx}"
    const val hiltAndroidxCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltAndroidx}"
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
        const val daggerHilt = "2.29-alpha"
        const val glide = "4.11.0"
    }

    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val daggerHilt = "com.google.dagger:hilt-android:${Versions.daggerHilt}"

    /* Hilt Core should only be used in non-Android modules */
    const val daggerHiltCore = "com.google.dagger:hilt-core:${Versions.daggerHilt}"
    const val daggerHiltProcessor = "com.google.dagger:hilt-android-compiler:${Versions.daggerHilt}"
    const val daggerHiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.daggerHilt}"

    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"

    /**
     * Configures all the required dependencies for Dagger Android
     */
    fun DependencyHandlerScope.daggerHilt() {
        add("implementation", dagger)
        add("kapt", daggerCompiler)
        add("implementation", daggerHilt)
        add("kapt", daggerHiltProcessor)
    }
}
