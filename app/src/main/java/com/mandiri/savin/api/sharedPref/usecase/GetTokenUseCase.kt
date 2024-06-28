package com.mandiri.savin.api.sharedPref.usecase

import com.mandiri.savin.api.sharedPref.repository.UserRepository
import javax.inject.Inject

class GetTokenUseCase @Inject constructor(
    private val repository: UserRepository
) {

    fun getToken() = repository.getToken()
}