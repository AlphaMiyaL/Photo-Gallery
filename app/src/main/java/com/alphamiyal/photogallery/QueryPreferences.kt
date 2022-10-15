package com.alphamiyal.photogallery

import android.content.Context
import androidx.preference.PreferenceManager
import java.util.prefs.Preferences

private const val PREF_SEARCH_QUERY = "searchQuery"

object QueryPreferences {
    fun getStoredQuery(context: Context): String{
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        //!! because won't ever be null since it will be supplied with empty string otherwise
        return prefs.getString(PREF_SEARCH_QUERY, "")!!
    }

    //not implementation 'androidx.core:core-ktx:1.0.0'
    fun setStoredQuery(context: Context, query: String) {
        PreferenceManager.getDefaultSharedPreferences(context)
            .edit()
            .putString(PREF_SEARCH_QUERY, query)
            .apply()
    }
}