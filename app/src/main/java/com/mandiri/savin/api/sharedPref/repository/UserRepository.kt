package com.mandiri.savin.api.sharedPref.repository

import com.mandiri.savin.api.sharedPref.local.LocalDataSource
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val datasource: LocalDataSource
) {
    fun getToken() = datasource.getToken()

    fun setToken(token: String) { datasource.setToken(token) }

    fun deleteToken() { datasource.deleteToken() }
}