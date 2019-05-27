package com.example.localcoffeeshop.Utils

import android.content.Context

class SharedPrefsLocally(context: Context) {
    val PREF_NAME = "SNHU"
    val PREF_LOG_COUNT = "LogCount"
    val pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun getLogCount():Int {
        return pref.getInt(PREF_LOG_COUNT, 0)
    }

    fun setLogCount(count:Int) {
        var edit = pref.edit()
        edit.putInt(PREF_LOG_COUNT, count)
        edit.apply()
    }
}