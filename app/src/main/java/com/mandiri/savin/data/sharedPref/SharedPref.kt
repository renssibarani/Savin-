package com.mandiri.savin.data.sharedPref

import android.content.SharedPreferences

class SharedPref(private val preferences: SharedPreferences) {
    fun saveToken(token: String) {
        preferences.edit().putString(KEY_TOKEN, token).apply()
    }

    fun getToken(): String {
        return preferences.getString(KEY_TOKEN, "") ?: ""
    }

    fun deleteToken() {
        preferences.edit().putString(KEY_TOKEN, "").apply()
    }

    companion object {
        private const val KEY_TOKEN = "key_token"
    }
}