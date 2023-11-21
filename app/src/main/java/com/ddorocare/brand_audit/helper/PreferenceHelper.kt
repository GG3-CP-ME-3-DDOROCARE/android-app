package com.ddorocare.brand_audit.helper

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper(context: Context) {
    private val PREF_NAME  = "SharedPreferencesInFo"
    private val sharedPref : SharedPreferences
    val editor : SharedPreferences.Editor


    init {
        sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        editor = sharedPref.edit()
    }

    fun put(key:String, value: String){
        editor.putString(key, value)
            .apply()
    }

    fun getString(key: String) : String?{
        return sharedPref.getString(key, null)
    }

    fun clear(){
        editor.clear()
            .apply()
    }

}