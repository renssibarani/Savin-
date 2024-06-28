package com.mandiri.savin.api.sharedPref.usecase

import com.mandiri.savin.api.sharedPref.repository.UserRepository
import javax.inject.Inject

class SetTokenUseCase @Inject constructor(
    private val repository: UserRepository
) {

    fun setToken(token: String) { repository.setToken(token) }
}