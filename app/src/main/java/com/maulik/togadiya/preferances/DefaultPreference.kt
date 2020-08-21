package com.maulik.togadiya.preferances

import com.maulik.togadiya.extension.className
import com.maulik.togadiya.extension.write
import org.json.JSONException

class DefaultPreference : BasePrefrence(){

    var data = NormalPreference()
    override val key = this.className()

    init {
        update()
    }

    /**
     * Created by Simform Solutions on 27 February 2020.
     **/
    override fun onPreferenceChanged(key: String) {
        if (key == this.key) {
            update()
        }
    }

    /**
     * Stores [DefaultPreference] into SharedPreferences
     * */
    fun store() {
        pref.write(key, gson.toJson(data))
    }

    private fun update() {
        data = pref.getString(key, "")?.let { value ->
            try {
                gson.fromJson(value, NormalPreference::class.java)
            } catch (e: JSONException) {
                e.printStackTrace()
                NormalPreference()
            }
        } ?: NormalPreference()
    }

}