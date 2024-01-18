package com.mandiri.savin.data.sharedPref.usecase

import com.mandiri.savin.data.sharedPref.repository.UserRepository
import javax.inject.Inject

class SetTokenUseCase @Inject constructor(
    private val repository: UserRepository
) {
    fun setToken(token: String) {
        repository.setToken(token)
    }
}