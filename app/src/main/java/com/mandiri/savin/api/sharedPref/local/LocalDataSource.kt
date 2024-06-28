package com.mandiri.savin.api.sharedPref.local

import com.mandiri.savin.api.sharedPref.SharedPref
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    val sharedPref: SharedPref
) {
    fun getToken() = sharedPref.getToken()

    fun setToken(token: String) { sharedPref.saveToken(token) }

    fun deleteToken() { sharedPref.deleteToken() }
}