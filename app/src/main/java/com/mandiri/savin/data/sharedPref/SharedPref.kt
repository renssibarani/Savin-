package com.mandiri.savin.data.sharedPref

import android.content.SharedPreferences
import com.google.gson.Gson
import com.mandiri.savin.model.ProfilResponse

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
    fun saveProfileData(profile: ProfilResponse) {
        val gson = Gson()
        val json = gson.toJson(profile)
        preferences.edit().putString("profile_key", json).apply()
    }

    fun getProfileData(): ProfilResponse? {
        val json = preferences.getString("profile_key", null)
        return if (json != null) {
            val gson = Gson()
            gson.fromJson(json, ProfilResponse::class.java)
        } else {
            null
        }
    }

    companion object {
        private const val KEY_TOKEN = "key_token"
    }
}