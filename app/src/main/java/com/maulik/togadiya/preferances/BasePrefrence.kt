package com.maulik.togadiya.preferances

import android.content.SharedPreferences
import com.google.gson.Gson
import com.maulik.togadiya.extension.remove
import org.koin.core.KoinComponent
import org.koin.core.inject

abstract class BasePrefrence : KoinComponent,SharedPreferences.OnSharedPreferenceChangeListener {
    val pref: SharedPreferences by inject()
    protected val gson =  Gson()
    protected abstract val key: String

    init {
        pref.registerOnSharedPreferenceChangeListener(this)
    }

    /**
     * This function will be called on preference changes
     * @param key is the key of changed busData
     * */
    abstract fun onPreferenceChanged(key: String)

    protected fun clear() {
        pref.remove(key)
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        key?.let {
            onPreferenceChanged(it)
        }
    }
}