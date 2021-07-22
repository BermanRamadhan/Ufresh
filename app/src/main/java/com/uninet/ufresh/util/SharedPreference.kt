package com.uninet.ufresh.util

import android.content.Context
import android.preference.PreferenceManager

class SharedPreference(val context: Context) {
    companion object{
        private const val  FIRST_INSTALL = "FIRST INSTALL"

    }
    private val pm = PreferenceManager.getDefaultSharedPreferences(context)

    var first_install = pm.getBoolean(FIRST_INSTALL,false)
    set(value) = pm.edit().putBoolean(FIRST_INSTALL,value).apply()
}