package com.mandiri.savin.data.sharedPref.repository

import com.mandiri.savin.data.sharedPref.local.LocalDataSource
import javax.inject.Inject

class UserRepository @Inject constructor(
    val datasource: LocalDataSource
) {
    fun getToken() = datasource.getToken()

    fun setToken(token: String) {
        datasource.setToken(token)
    }

    fun deleteToken() {
        datasource.deleteToken()
    }
}