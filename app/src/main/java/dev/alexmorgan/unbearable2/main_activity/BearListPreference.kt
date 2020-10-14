package dev.alexmorgan.unbearable2.main_activity

import android.content.SharedPreferences
import javax.inject.Inject

class BearListPreference @Inject constructor(private val preferences: SharedPreferences) {

    var formatPreference: Format = Format.LIST
        get() {
            return kotlin.runCatching {
                Format.valueOf(
                    preferences.getString(FORMAT_PREFERENCE_KEY, "") ?: ""
                )
            }.getOrElse { Format.LIST }
        }
        set(value) {
            field = value
            preferences.edit().putString(FORMAT_PREFERENCE_KEY, value.name).apply()
        }

    companion object {
        const val FORMAT_PREFERENCE_KEY = "bear_list_format_preference"
    }

    enum class Format {
        GRID,
        LIST
    }
}