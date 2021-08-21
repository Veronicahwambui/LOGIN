
package com.example.codehiveregistrationtwo.models

import android.content.Context
import android.content.SharedPreferences
import com.example.codehiveregestrationtwo.R

class SessionManager (context: Context) {
    private var prefs: SharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    companion object {
        const val USER_TOKEN = "ACCESS_TOKEN"
    }

    fun saveAuthentication(token: String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    fun fetchAuthentication(): String? {
        return prefs.getString(USER_TOKEN, null)
    }
}