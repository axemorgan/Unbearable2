package dev.alexmorgan.unbearable2.main_activity

interface BearSource {
    suspend fun getAllBears(): List<Bear>
}