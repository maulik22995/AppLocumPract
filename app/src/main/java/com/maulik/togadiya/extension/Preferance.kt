package com.maulik.togadiya.extension

import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.JsonParseException

val gson = Gson()
/**
 * Extension to clear [SharedPreferences]
 * */
fun SharedPreferences.clear() = this.edit().clear().apply()

/**
 * Extension function to remove a key-value pair from [SharedPreferences]
 * */
fun SharedPreferences.remove(key: String) = this.edit().remove(key).apply()

/**
 * Extension function for [SharedPreferences] to modify it in asynchronously
 * @param key is the key for [SharedPreferences]
 * @param value is the data which will be stored into [SharedPreferences]
 * */
fun SharedPreferences.write(key: String, value: Any) =
    this.edit()?.apply {
        when (value) {
            is String -> putString(key, value)
            is Int -> putInt(key, value)
            is Long -> putLong(key, value)
            is Float -> putFloat(key, value)
            is Boolean -> putBoolean(key, value)
        }
        apply()
    }

/**
 * Extension for set operator for [SharedPreferences] which will be
 * used to save data into [SharedPreferences]
 * */
operator fun SharedPreferences.set(key: String, value: Any) =
    this.edit()?.apply {
        putString(key, gson.toJson(value))
    }?.commit()

/**
 * Extension to get value from preferences
 */
@Suppress("UNCHECKED_CAST")
inline operator fun <reified T> SharedPreferences.get(key: String): T {
    try {
        return gson.fromJson<T>(getString(key, ""), T::class.java)
    } catch (e: JsonParseException) {
        throw JsonParseException("KEY_NOT_EXITS")
    }
}

/**
 * Extension function to retrieve name string of any class
 * */
inline fun <reified T : Any> T.className(): String = this::class.java.simpleName